# docker compose를 활용한 개발 환경 구축

## 준비사항

- hosts 추가

```
127.0.0.1 pub.gmarket.co.kr
127.0.0.1 sub.gmarket.co.kr
127.0.0.1 frontend.gmarket.co.kr
```

- Backend 구동
 > [gmarket-techblog-backend git 참조](https://github.com/jayjlee29/gmarket-techblog-backend)

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