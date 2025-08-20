pipeline {
   agent {
        docker {
            image 'docker:24.0.5'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    environment {
        IMAGE_NAME = "192.168.18.200:9000/bee"
        IMAGE_TAG = "${env.BUILD_NUMBER}"  // 每次构建的唯一版本
        K8S_NAMESPACE = "default"
        DEPLOYMENT_NAME = "spring-data-deployment"
        CONFIGMAP_NAME = "spring-data-config"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/hbkgoing/SS-SDK.git/'
            }
        }

        stage('Build') {
            steps {
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                    docker build -t $IMAGE_NAME:$IMAGE_TAG .
                    docker push $IMAGE_NAME:$IMAGE_TAG
                """
            }
        }

        stage('Update K8s Deployment') {
            steps {
                sh """
                kubectl set image deployment/$DEPLOYMENT_NAME spring-data=$IMAGE_NAME:$IMAGE_TAG -n $K8S_NAMESPACE
                kubectl rollout status deployment/$DEPLOYMENT_NAME -n $K8S_NAMESPACE
                """
            }
        }

        stage('Update ConfigMap') {
            steps {
                sh """
                kubectl create configmap $CONFIGMAP_NAME \
                    --from-literal=APP_VERSION=$IMAGE_TAG \
                    -n $K8S_NAMESPACE \
                    --dry-run=client -o yaml | kubectl apply -f -
                """
            }
        }
    }

    post {
        success {
            echo "Deployment successful: $IMAGE_NAME:$IMAGE_TAG"
        }
        failure {
            echo "Deployment failed!"
        }
    }
}
