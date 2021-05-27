pipeline {
	agent {
		label 'docker'
	}
	stages {
		stage('Build') {
			steps {
				echo 'Building ...'
				sh mvn package -DskipTests
				stash(name='WAR', includes='**/target/webcalc.war')
			}
		}
		stage('Test') {
			steps {
				echo 'Testing ...'
			}
		}
		stage('Deploy') {
			steps {
				echo 'Deploying ...'
			}
		}
	}
	post {
		always {
			echo '-> PIPELINE is complete <-'
		}
	}
}
