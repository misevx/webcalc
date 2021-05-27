pipeline {
	agent {
		label 'docker-prod'
	}
	stages {
		stage('Build') {
			echo 'Building ...'
		}
		stage('Test') {
			echo 'Testing ...'
		}
		stage('Deploy') {
			echo 'Deploying ...'
		}
	}
	post {
		always {
			echo '-> PIPELINE is complete <-'
		}
	}
}
