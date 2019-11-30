* If data.sql, then also  _schema.sql. Data JPA creates schema later than data.sql is exectued


was ist default für hibernate ddl? weicht das im test ab?

spring:
  jpa:
    hibernate:
      ddl-auto
Defaults to "create-drop" when using an embedded database and no schema manager was detected. Otherwise, defaults to "none".

wenn data.sql vorhanden, schema.sql fehlt, validate
org.hibernate.tool.schema.spi.SchemaManagementException: Schema-validation: missing table [person]