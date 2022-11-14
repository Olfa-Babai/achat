pipeline {
          agent any
          
        
          stages{
            stage('Checkout GIT'){
                steps{
                    echo 'Pulling...';
                    git branch: 'brancheEya',
                    url : 'https://github.com/Olfa-Babai/achat.git';
                }

            }
            stage('MVN CLEAN'){
            steps{
                echo 'Pulling...';
                sh 'mvn clean'
                }
            }
             stage('MVN COMPILE'){
                steps{
                sh 'mvn compile'
                }
             }
             stage('MVN PACKAGE'){
                steps{
                sh 'mvn package -DskipTests=true'
                }
             }
             stage('MVN Test'){
                steps{
                sh 'mvn test'
                }
             }
              stage('MVN SONARQUBE '){
                 steps{
                    sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=54243838'
                 }
              }
                     stage("nexus deploy"){
                  steps{
                  nexusArtifactUploader artifacts: [[artifactId: 'achat', classifier: '', file: '/var/lib/jenkins/workspace/Projet/target/achat-1.0.jar', type: 'jar']], credentialsId: 'nexus-user-credentials', groupId: 'tn.esprit.rh', nexusUrl: '192.168.33.10:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-nexus-repo', version: '1.0.0'
                  }
               } 
                  
              /* DOCKER */
 stage('Build Docker Image') {
                  steps {
                  sh 'docker build -t ouellani/docker_spring:2.2.4 .'
                  }
               }
//////////*DOcker push image*//////////////////
                 stage('Push image to docker hub') {
            steps {
                echo "<Pushing Docker Image>";
                script{ 
                    def mavenPom = readMavenPom file: 'pom.xml'
                    withCredentials([string(credentialsId: 'docker-credentials', variable: 'dockerPasswd')]) {
                        sh "docker login -u eyaouellani-p ${dockerPasswd}"
                    }  
                    sh "docker push ouellani/img:tagname:${mavenPom.version}" 
                }
            }
        }

        stage('Docker Compose') {
            steps {
                echo "<Running Docker Compose>";
                sh "docker-compose build"
                sh "docker-compose up -d"
            }
        }
        
    }
 post {
        failure {
            mail to: "eya.ouellani@esprit.tn",
            subject: "${env.PROJECT_NAME} - Build # ${env.BUILD_NUMBER} - ${env.BUILD_STATUS}!",
            body: "Check console output at ${env.BUILD_URL} to view the results."
        }
        success {
            mail to: "ouellanieya@gmail.com",
            subject: "${env.PROJECT_NAME} - Build # ${env.BUILD_NUMBER} - ${env.BUILD_STATUS}!",
            body: "Job has finished successfully."
        }
    }
          }
