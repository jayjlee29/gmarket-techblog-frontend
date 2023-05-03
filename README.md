# Part 2 : docker-compose를 이용하여 spring boot 프로젝트 연결하기

## 준비사항

- hosts 추가

```
127.0.0.1 pub.gmarket.co.kr
127.0.0.1 sub.gmarket.co.kr
127.0.0.1 frontend.gmarket.co.kr
```

- Backend 구동
  - [[Gmarket Techblog] docker-compose를 이용하여 로컬 개발환경 구성하기(Part1) 참조](https://dev.gmarket.com/72)
  - [[Github] gmarket-techblog-backend 참조](https://github.com/jayjlee29/gmarket-techblog-backend)

## Build

```bash
docker compose up builder
```

## Run Application

```bash
docker compose up frontend
```



## 브라우저 접속

```
http://frontend.gmarket.co.kr
```