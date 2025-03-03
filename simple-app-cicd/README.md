# Construir la imagen Docker
docker build -t spring-boot-demo .

# Ejecutar el contenedor
docker run -p 8080:8080 spring-boot-demo