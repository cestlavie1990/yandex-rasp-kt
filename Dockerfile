FROM amazoncorretto:17.0.8

ADD build/libs/yandex-rasp-kt-*.jar /yandex-rasp-kt/yandex-rasp-kt.jar

WORKDIR yandex-rasp-kt

EXPOSE 8080

CMD java -jar yandex-rasp-kt.jar