pipeline {
	agent {
		label 'docker-prod'
	}
	stages {
		stage('Build') {
			steps {
				echo 'Building ...'
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
