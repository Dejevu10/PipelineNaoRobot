node {
    stage('build jar'){
        git 'https://github.com/Dejevu10/PipelineNaoRobot.git'
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
        
       	junit './target/surefire-reports/*.xml'
    }
}