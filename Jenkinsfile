pipeline {
	agent any
	stages {
		stage('Build') {
			steps {
				echo 'Building ...'
				sh 'mvn package -DskipTests'
				stash(name: 'WAR', includes: 'target/webcalc.war')
			}
		}
		stage('Test') {
			parallel {
				stage('Tomcat Test') {
					steps {
						echo 'Testing with Tomcat'
						unstash 'WAR'
						sh 'find . -name webcalc.war'
					}
				}
				stage('Wildfly Test') {
					steps {
						echo 'Testing with Wildfly'
						unstash 'WAR'
						sh 'find . -name webcalc.war'
					}
				}
				stage('Weblogic Test') {
					steps {
						echo 'Testing with Weblogic'
						unstash 'WAR'
						sh 'find . -name webcalc.war'
					}
				}
			}
		}
		stage('Deploy') {
			parallel {
				stage('Deploy to Tomcat') {
					steps {
						echo 'Deploying to Tomcat'
						unstash 'WAR'
						archiveArtifacts(artifacts: 'target/webcalc.war', onlyIfSuccessful: true)
						sh 'cp target/webcalc.war /tomcat_webapps_dir'
					}
				}
				stage('Deploy to Wildfly') {
					steps {
						echo 'Deploying to Wildfly'
						unstash 'WAR'
						archiveArtifacts(artifacts: 'target/webcalc.war', onlyIfSuccessful: true)
						sh 'cp target/webcalc.war /wildfly_webapps_dir'
						sh 'touch /wildfly_webapps_dir/.dodeploy
					}
				}
			}
		}
	}
	post {
		always {
			echo '-> PIPELINE is complete <-'
		}
	}
}
