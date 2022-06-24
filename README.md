# kafka-queue-example
Aplicação com producer e listener kafka

# imagens Docker
Mongo
	docker run -d -p 27017:27017 -p 28017:28017 -e AUTH=no tutum/mongodb
	
	
Kafka
	docker run -d --name kafka-mkp -p 2181:2181 -p 9092:9092 allansilva/kafka4dev:1.0.2-scala.2.12
