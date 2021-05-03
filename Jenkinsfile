pipeline {
    agent any
    options {
        // This is required if you want to clean before build
        skipDefaultCheckout(true)
    }
    parameters {
        string (
            defaultValue: '*',
            description: '',
            name : 'BRANCH_PATTERN')
        booleanParam (
            defaultValue: false,
            description: '',
            name : 'RELEASE_BUILD')
    }

    stages {
         stage ('Clean up') {
             steps {
                 cleanWs()
             }
         }
        stage ('Check') {
            steps {
                checkout([$class: 'GitSCM',
                    branches: [[name: "origin/${BRANCH_PATTERN}"]],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'LocalBranch']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                        url: 'https://github.com/cigbe00/ConversionScale.git']]])
            }
        }
            
          stage ('Release Build') {
            when {
                expression {
                    GIT_BRANCH = 'origin/' + sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
                    return GIT_BRANCH == 'origin/master' || params.RELEASE_BUILD
                }
            }
            steps {
                // Freestyle build trigger calls a list of jobs
                // Pipeline build() step only calls one job
                // To run all three jobs in parallel, we use "parallel" step
                // https://jenkins.io/doc/pipeline/examples/#jobs-in-parallel
                echo 'compiling source'
                echo "${WORKSPACE}"
            }
        }
        stage ('Build Private branch') {
            when {
                expression {
                    GIT_BRANCH = 'origin/' + sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
                    return !(GIT_BRANCH == 'origin/master' || params.RELEASE_BUILD)
                }
            }
            steps {
                echo 'building from private branch.'
            }
        }
       stage(' tar and upload') {
             steps {
                        sh 'pwd'
                        sh 'jar cvf jenkinsscale.jar bin/driver_classes/NumericConversion.class'
                   }

       }
    }
    post {
        // Clean after build
        always {
            cleanWs(cleanWhenNotBuilt: false,
                    deleteDirs: true,
                    disableDeferredWipeout: true,
                    notFailBuild: true,
                    patterns: [[pattern: '.gitignore', type: 'INCLUDE'],
                               [pattern: '.propsfile', type: 'EXCLUDE']])
        }
    }
} 
       
