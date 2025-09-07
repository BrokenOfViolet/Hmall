黑马商城

采用docker部署,

启动命令:
mvn clean install
mvn sprin-boot:run

hm-common: 通用功能
hm-service: 单体架构,包含完整功能

拆分成
user-service
item-service
trade-service
pay-service
hm-api
hm-gateway: 负责

nginx关键配置:
```nginx
# 根项目
server {
listen 80;
server_name localhost;

        root /Users/mac/Vscode/html;
        index index.html index.htm;

        location / {
            try_files $uri $uri/ =404;
        }

        error_page 500 502 503 504 /50x.html;
        location = /50x.html {
            root /Users/mac/Vscode/html;
        }
    }

    # hmall-portal
    server {
        listen 18080;
        server_name localhost;

        root /Users/mac/Vscode/html/hmall-portal;
        index index.html index.htm;

        location / {
            try_files $uri $uri/ /index.html;
        }

        location /api {
            rewrite /api/(.*) /$1 break;
            proxy_pass http://localhost:8080;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Real-PORT $remote_port;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        }

        error_page 500 502 503 504 /50x.html;
        location = /50x.html {
            root /Users/mac/Vscode/html;
        }
    }

    # hmall-admin
    server {
        listen 18081;
        server_name localhost;

        root /Users/mac/Vscode/html/hmall-admin;
        index index.html index.htm;

        location / {
            try_files $uri $uri/ /index.html;
        }

        location /api {
            rewrite /api/(.*) /$1 break;
            proxy_pass http://localhost:8080;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Real-PORT $remote_port;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        }

        error_page 500 502 503 504 /50x.html;
        location = /50x.html {
            root /Users/mac/Vscode/html;
        }
    }

    # hm-refresh-admin
    server {
        listen 18082;
        server_name localhost;

        root /Users/mac/Vscode/html/hm-refresh-admin;
        index index.html index.htm;

        location / {
            try_files $uri $uri/ /index.html;
        }

        location /api {
            rewrite /api/(.*) /$1 break;
            proxy_pass http://localhost:8080;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Real-PORT $remote_port;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        }

        error_page 500 502 503 504 /50x.html;
        location = /50x.html {
            root /Users/mac/Vscode/html;
        }
    }
```

update at 20225/08/06\
update at 2025/09/07