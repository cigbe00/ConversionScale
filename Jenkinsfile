pipeline {
        agent any
                stages {
                         stage('cleanup workspace') {

                                             steps {
                                                     echo 'performing workspace cleanup'
                                                     pwd
                                                     echo $WORKSPACE
                                             }

                         }

                         stage('Compile source') {

                                             steps {
                                                     echo 'compiling java code'
                                            }

                         }

                         stage(' tar and upload') {
                                         steps {
                                                 jar cvf jenkinsscale.jar bin/driver_classes/NumericConversion.class
                                         }

                         }



                }





}