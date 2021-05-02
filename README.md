# pull이 안될 경우, detail 확인시 Nothing to fetch  문제라고 뜬다면 remote를 해결해 줘야 함!
참고 : https://d-e-v.tistory.com/5
Git Repositories 탭에서 git 프로젝트 오른쪽 클릭 - Properties
fetch 추가.
fork되어있던 프로젝트를 복사해서 수정한거라 remote에 origin과 originA가 있을 것.(나만 그럴 수도 있음)
우리는 originA!
origin을 지우면 더 편함. 이 remote는 jpetstore로 연결되므로 pull도 그쪽으로 갈 수 있음
pull할 때 깃주소 확인 잘하기.

# 지금은 master 브랜치에 모두 merge하고있지만 대략적인 구현(프로젝트 마무리)이 끝나고나면 이후 짜잘한 수정부터는 develop브랜치에 pull하도록 합시다!



# JPetStore (boot)
JPetStore project based on Spring Boot 2

####변경 사항     
1. pom.xml: starter dependencies 사용
2. com.example.jpetstore.JpetstoreBootApplication: 시작 및 설정 클래스 
3. com.example.jpetstore.WebMvcConfig: Spring MVC 관련 설정 클래스
4. com.example.jpetstore.controller.SignonInterceptor: @Component 추가 (bean scan 대상)
5. com.example.jpetstore.controller.dao.mybatis.mapper.*: @Mapper 추가 (mapper scan 대상)
6. src/main/resources/application.properties: bean property 설정
7. src/main/resources/{기존 properties, xml 설정 파일} 삭제
8. src/main/webapp/{images, style, *.html}를 src/main/resources/static/ 으로 이동 
9. src/main/webapp/META-INF 삭제
10. src/main/webapp/WEB-INF/*.xml 삭제
11. src/main/webapp/WEB-INF/lib/ojdbc6.jar 삭제
 
####실행
* Eclise: com.example.jpetstore.JpetstoreBootApplication 선택 > Run As > Java Application  
* Maven: mvnw spring-boot:run
* http://localhost:8080/ 

