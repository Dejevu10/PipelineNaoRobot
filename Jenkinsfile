node {
    stage('build jar'){
    
    	echo "Pulling from github"
        git 'https://github.com/Dejevu10/PipelineNaoRobot.git';
        
        echo "Building the docker Image"
        sh "docker build -t naowebapp:${env.BUILD_NUMBER} -f test_docker_osx ."
    }
 
 
    stage('maven surefire-unittest'){
        //tbd
		
		//build unittest docker image
		sh "docker build -t unittest -f test_docker_unittest_osx ."
		
		//run the container
		sh "docker run --name unittest unittest:latest"
		
		//publish test results to host
		sh "docker cp unittest:/target/surefire-reports/ target/"
		
		//remove container
		sh 'docker rm $(docker ps -aq)'
        
        
    }
    
    stage('maven surefire-integrationtests'){
        //tbd
		
		sh "docker build -t integrationtest -f test_docker_integrationtest_osx ."
		
		sh "docker run --name integrationtest integrationtest:latest";
		
		sh "docker cp integrationtest:/target/surefire-reports/ target/"
		
		//remove container
		sh 'docker rm $(docker ps -aq)'
        
    }
    
    stage('publish test resports'){
                       
        junit '**/target/surefire-reports/*.xml' 
        
     }

    
    stage('publish to docker-hub'){
        
        echo "Starting the push phase"
        
       	sh 'docker login --username mselcuk1994 --password admin2019'
       	
       	sh "docker tag naowebapp:${env.BUILD_NUMBER} mselcuk1994/naowebapp:${env.BUILD_NUMBER}"  
       	
		sh "docker push mselcuk1994/naowebapp:${env.BUILD_NUMBER}"
       	
    }
}