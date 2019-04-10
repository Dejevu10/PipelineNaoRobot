node {
    stage('build jar'){
    
    	echo "Pulling from github"
        git 'https://github.com/Dejevu10/PipelineNaoRobot.git';
        
        echo "Building the docker Image"
        sh "docker build -t naowebapp:${env.BUILD_NUMBER} -f test_docker_osx ."
    }
 
 
    stage('maven surefire-unittest'){
        //tbd
//        sh 'docker-compose build '
        
        
    }
    
    stage('maven surefire-integrationtests'){
        //tbd
//        sh 'ls'
//        sh 'mvn clean install'
        
    }
    
    stage('publish to docker-hub'){
        
        echo "Starting the push phase"
        
       	sh 'docker login --username mselcuk1994 --password admin2019'
       	
       	sh "docker tag naowebapp:${env.BUILD_NUMBER} mselcuk1994/naowebapp:${env.BUILD_NUMBER}"  
       	
		sh "docker push mselcuk1994/naowebapp:${env.BUILD_NUMBER}"
       	
    }
}