1. Pastikan mysql sudah berjalan
2. buat database
3. ubah configurasi di src/main.resources/application.properties
     spring.datasource.url=jdbc:mysql://localhost:3306/{{nama_database}}
     spring.datasource.username={{username_mysql}}
     spring.datasource.password={{password_mysql}}
4. Build dan Sync Project
5. Buka File src/main/com/DemoApplication.Java dan Run Filenya 
