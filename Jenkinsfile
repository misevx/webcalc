pipeline {
	agent {
		label 'docker'
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
