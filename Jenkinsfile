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
			steps {
				echo 'Testing and looking for artifact'
				unstash 'WAR'
				sh 'find . -name webcalc.war'
			}
		}
		stage('Deploy') {
			steps {
				echo 'Deploying ...'
				unstash 'WAR'
				sh 'find . -name webcalc.war'
				archiveArtifacts(artifacts: 'target/webcalc.war', onlyIfSuccessful: true)
			}
		}
	}
	post {
		always {
			echo '-> PIPELINE is complete <-'
		}
	}
}
