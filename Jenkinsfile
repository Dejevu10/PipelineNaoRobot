node {
    stage('build jar'){
        git 'https://github.com/Dejevu10/PipelineNaoRobot.git';
        
        sh "docker build -t naowebapp:${env.BUILD_NUMBER} -f test_docker_osx ."
    }
    
    stage('maven surefire-unittest'){
        //tbd
//        sh 'docker-compose build '
        
        
    }
    
    stage('maven surefire-integrationtests'){
        //tbd
        sh 'ls'
        sh 'mvn clean install'
        
    }
    
    stage('maven report integrationtests'){
        
       	junit 'target/surefire-reports/*.xml'
    }
    
        stage('publish to docker-hub'){
        
       	sh 'docker login --username mselcuk1994 --password admin2019'
       	
		sh "docker push mselcuk1994/naowebapp:${env.BUILD_NUMBER}"  
       	
    }
}