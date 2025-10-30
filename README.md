🚀 Secure Search Cloud

Secure Search Cloud is a Java-based web application that enables users to securely upload, store, and search text data using Spring Boot and MongoDB. It demonstrates seamless cloud deployment with Docker and Render, providing a full-stack example of how to build and deploy secure data search services.

🌐 Live Demo

👉 https://secure-search-cloud-1.onrender.com/

🧩 Features

🔒 Secure Upload: Upload and store text content in a MongoDB database.

🔍 Keyword Search: Search for specific keywords across stored files.

✅ Keyword Verification: Instantly check if a keyword exists in the database.

☁️ Cloud Deployment: Deployed using Docker on Render Cloud.

⚙️ RESTful APIs: Built with Spring Boot, MongoDB, and Thymeleaf UI.

🧱 Tech Stack
Category	Technology
Backend	Java, Spring Boot
Database	MongoDB
Frontend	HTML, CSS, Thymeleaf
Deployment	Docker, Render
Build Tool	Maven

🗂️ Project Structure
secure-search-cloud/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/securesearch/
│   │   │   ├── controller/       # REST Controllers
│   │   │   ├── model/            # Data Models
│   │   │   └── repository/       # MongoDB Repositories
│   │   └── resources/
│   │       ├── templates/        # Thymeleaf Templates (index.html)
│   │       └── application.properties
│   └── test/
│
├── pom.xml                       # Maven Configuration
├── Dockerfile                    # Docker Setup
├── mvnw, mvnw.cmd                # Maven Wrapper
└── README.md

⚙️ Setup and Installation
1️⃣ Clone the repository
git clone https://github.com/yourusername/secure-search-cloud.git
cd secure-search-cloud

2️⃣ Configure MongoDB

Open src/main/resources/application.properties and update your MongoDB connection:

spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<cluster-url>/securesearch
spring.application.name=secure-search
server.port=8080

3️⃣ Build the project
mvn clean package -DskipTests

4️⃣ Run locally
java -jar target/secure-search-cloud-0.0.1-SNAPSHOT.jar


Then visit 👉 http://localhost:8080

🐳 Docker Deployment
Build Docker image
docker build -t secure-search-cloud .

Run Docker container
docker run -p 8080:8080 secure-search-cloud

🌩️ Deployment on Render

Push your project to GitHub.

Log in to Render
.

Create a New Web Service → Connect your repository.

Set environment:

Environment: Docker

Build Command: handled by Dockerfile

Deploy 🚀

🧠 API Endpoints
Method	Endpoint	Description
POST	/upload?text=yourText	Upload text data
GET	/search?keyword=word	Search text for keyword
GET	/verify?keyword=word	Verify if keyword exists
