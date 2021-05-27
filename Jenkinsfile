pipeline {
	agent {
		label 'docker'
	}
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
			steps {
				echo 'Deploying ...'
				unstash 'WAR'
				sh 'find . -name webcalc.war'
				archiveArtifacts(artifacts: 'target/webcalc.war', onlyIfSuccessful: true)
				sh 'cp target/webcalc.war /tmp'
				sh 'df -kh'
			}
		}
	}
	post {
		always {
			echo '-> PIPELINE is complete <-'
		}
	}
}
