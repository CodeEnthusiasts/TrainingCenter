# Training Center 

Web app that allow to create own personal training diary. Do you train and want to monitor your progress by adding exercises, 
sets reps and weights to achieve better results? This app is perfect for you, and also suitable for people who are interested 
in endurance-type sports. 

**If you just want to know how to contribute, visit : [Guide](https://github.com/CodeEnthusiasts/TrainingCenter/wiki/How-to-contribute%3F)**

## Table of contents
* General info
* Changelog
* Deployment Guide
    * Requirements for developers
    * Running application on local machine
    * Connecting with database
* Data model
    * UML graph
    * Database structure graph
* Planned features
* Technologies
    * Backend
    * Frontend
* Troubles
    * FAQ
* Contributors
* License

## General info
Track and analyze results of trainig is key to progress, so the assumpion of this application is to create personal training 
history with features that allow to reflect on your training plan - get to know your body better, draw conclusions and adapt the plan 
to you -> all to achieve better and faster results. <br> Appliaction allow to add muscles, images and manage you whole training plan. 
You don't have to worry about total tonnage, increase in intensity or muscle overload - algorithm created with guidance of 
experienced trainers will do it for you. It is also helpful for novice and people who love competing, because app allows 
to list exercises with correct technique, and also compete with other members in exercises records and other achievements.

## Changelog

## Deployment Guide
#### Requirements for developers
1. **Java JDK** (< 11) download from [Oracle](https://www.oracle.com/pl/java/technologies/javase-downloads.html)
2. **IntelliJ IDEA** download from [JetBrains](https://www.jetbrains.com/idea/download/#section=windows)
3. **GIT** download from [git-scm.com](https://git-scm.com/downloads) 
 
#### Running application on local machine
1. Run Git Bash and go to the desired location.
2. Clone repository:
```cmd
git clone https://github.com/CodeEnthusiasts/TrainingCenter.git
```
3.Open workspace in your IDE.

![info_picture](readme-img/open_project.PNG)

#### Connecting with database
1. Open Database Tool Windows - [more info](https://www.jetbrains.com/help/idea/database-tool-window.html)
2. Click icon **+** and choose **Datasource -> H2**
3. Config your connection based on the file **application.properties**
    * port: 8081
    * url: jdbc:h2:mem:testdb
    * driverClassName: driverClassName=org.h2.Driver
    * username: admin
    * password: admin
4. Download an additional driver via IDE.

![info_about_db](readme-img/test_db.PNG) 

![info_about_db_2](readme-img/test_db_2.PNG)

## Data model
* ERD diagram:
[Diagrams.net](https://viewer.diagrams.net/?highlight=0000ff&edit=_blank&layers=1&nav=1&title=TrainingCenterERD.drawio#R7Z1dU%2BM4FoZ%2FDVW7F1C25a9cNjTTUEM3vUBP784N5SYGvJMPxnEa2F%2B%2FdmLZIVIaKbakI1ldU7vGCQnxefNYenXO0QE6mb58ypOnx8%2FzcTo58JzxywH6eOCV%2FyK3%2FL%2FqzCs%2Bg%2Fz1mYc8G6%2FPue2J6%2Bx%2FaX3Sqc8us3G6ePPEYj6fFNnT25N389ksvSvenEvyfP789mn388nbd31KHlLixPVdMiHPfs%2FGxWN91g1H7QNnafbwWL917IXrB34kd3895PPlrH6%2FAw%2Fdr%2F6tH54m%2BLXqD7p4TMbz541T6PQAneTzebE%2Bmr6cpJPq4uLLtv6933Y82vzdeTorWH4BHR9Pz90%2Fvntn3xenHw8fPp19ODx0nXj9Oj%2BTybK%2BIt8Wab6o%2F%2BbiFV%2Bn8s9%2Fqg6L5Ed16nhRJHlRhxM55YkyQEWSzdK8POGufp5MkqdFtnr6%2BsxjNhlfJK%2FzZYFfCP90fJ%2B9pOOrdTSr55aBvShfrPqxevH78sWv6z%2BmejiZZA%2Bz8viu%2FPDVOx7n6aL8Wy6SRVE%2Fg7w89RX7meZF%2BrJxqr5cn9L5NC3y1%2FIp9aOHsVPHrhb3oRuE9ZnnViteVJ973JCJG9cnk1qfD83LtzEqD%2BowcYVsRIRsZ7TKz19kyeSq%2FOYks4dV4N7Gpbq443z%2BdJPkD2lRn3iaZ9VlPf1ZXrsmAtlkcjKfzKvwzuaz6pWK%2BVP94CS9x7%2F7Y14U8ymOYn1BmhddXYzguPyvvDwnzlFwEJR%2F7kn5s9v%2BXP5XPT0vTuazRZGXoqpeIy1j%2B5xW8aXE9h1xvx%2FyOsKIMbxIWHQxFzei%2B%2FV3vviuQJm08eUOnbMVuu1v37y8oPeTFcwes%2FE4nfHEZMQck40gILkxcIkYlL9w4h18KN%2FSEXdwfP7p%2FMtNefDlcvW%2F3y4uFEcec3b93OPFU3KXzR4u1r8ZbkkjkCeNl91fV1%2BuVDwtYLwdVy1gzHqvFRhd1DG6vX8h03GGX68riRvpQiaxTwRgWQ5PZ8k0ZSfrHx%2BuTs4%2BXP0Def9cs1UHsEqKLByQBhakokA6Ug%2FS0GSQBswBUQfSiAjAU7JYPM9zvoHt8FjKHlw4LCVNHcvSnljqeuph2tUAAg1T9ogogymWwEYA0mmSTfo1BDBqY2coqGUPPRjUeqRVZFHbF2oD5ajF0TQStRwrIupQSzowdtzac3DhwJScpFSLkR%2FTory52iXJ8pFDhE1RvCQ58gM2SHriViQ9PeYbAFYkG4VrtCLpkdMNo1YkPQ1mHPiVZa9I7joY%2BEolh2TA3FyRnakIg7T6lUpk8kQFaTBRQeRE5Xn9xsJQfH12eXUDHbuS4g4Hs%2BSKtcVsT5hVv46Juq5Sg8aszxwQdZglF5KrBG%2FpA2Dz2csuBjjsJf0jy96e2Atg3RN1tZlAw5c9IurgSzpBi%2FJvlQ7fTTN%2F%2BykGE5ldIWCIjN%2FNElkAkdUvj%2FpdPSXIRG60C5jIPmn7rN%2F42yzr6jy8WTI1F6scYYaD1a7ptBaru7Eaq8dq13kMaKyGzBFRh1VypvFjPn79%2Fi5ah8JM9hjCYaYeZdNaMrPp5qCOmXgwvBHe31RnKfRJTQ3KpgNK2fQ0eUhve0pV2Ew60CHjQFK8oRAW%2BV2rZS1hdxPWV01Y5JMrmwYRtlUvXMIin1x%2BrMqh%2BwLs5sGAYMsTeiiwdSNSCqez8TJPZndpGYsqP35XxAaULx3joDQdnHzK9B7RQicwXzrSw74BkC8dsVff7s6XpoZX4DeTdG%2BMypeONDBwItLAUZovvcdN92B4adUcytp9H0auXKVZW0kYyylp1ZJZjscARjrxkQaeUkx6SuOkUJDw9%2BuDjx9uTqGTWpJUwJA59iyZRZGZkoktm8wmt%2BZrpAuZzKQdOM4WReU%2FqEHw5bfjixLCzter05Pz6%2FPLLyYDmUMhcIBsW%2FwJAzItPVs2kU3u8Rdr0OMvJo0nTOTbZfd8wMFmCHLEHg5r9WjJoSdrKYnXsllrcgvAWIOGHHgCtMnaZZ4U2XymZPR7c%2F65Gvt%2BP785u%2Fx205748%2FLLqfmlMRyKAUPoke3HIY7QrIu8AsPb1X2CTOgR%2B0K8OkKTBtG0%2FMzT8qPd8u0fQBvyBo7RQ16OAMMBqu28IQyotARv2UA1ufXGSIPWGyPS3ymyqSBrgasG3GQQ99GGQzaIbRsOcSCm5IHLBjFpLRmUB96qFzKKSftHVB74fuU5B3okr0nSCRQye3g%2FWzhjqJ5CtEcjbWwR4MxwWtm3VLB6jhndNPhj4bvvx0IqYD2HNA%2Bui%2FIjPhSPtrhid3GF65DN6JFHiZy44grP0cMGUF9c0Yq8U3EFLbwCv5ikC2BScUWrXrijT88hjQBbXAG9uIJHWb8ochzJVZp1EoSxnFZcIZnlBvfzbKULGeSkjWCLK6Q7CTxSAUNmPGOzZO6fzLTiCrlkds1wIt6RLmAyux4RgDx9WgABcnNgehd8Hq3AQbNtwyQMzdQyC8ls7upvgWYz%2FCZMnktaUCWb0yKrkn97zYYYRo4DT9DhQFaPFj56QpZWXyEZsgZ3YG61CxmypDckejs9W2TcQShwwGz78YgDM21dXi6Y8buZCWb4DXnaNIFtMAvOAx7KWLiXvs9ykYu%2Fgha5%2FSOXWnghGbkGd9pptQsZuaTj07WSbRhlbDzRhUNT2yVHHE1p1ROSaUoaRwZVT7TqhcxT0tyBVT2hQ2qaJJGAwTIi5z0ny0V58Ww%2B%2BM588ChixG3TTkVA3PSYnABIB0fsAQeTDo7IuYlR6eCNegHfThE5PbHp4ODTwTmUBecebKdGwliuPh0cGdw%2FtJUuZJBT%2BofadHDpsyMOqcAhs203KozM6tPBkcHdRlvpAiYznlhvkjld3OXZk6SGo3i9wHXMXjDgEAMY9vq2kagw9gLI9%2Fa7GliQ4euzR0QdfEmPaX0IZDg8qJREDsGAAXRgC3LEAVp9rnhg9L7orXoBIzqQty%2F69gGbwayDuyxJJHCwTPqNNxW7yqvydZLMdoZrQCu6hwjbwnhJN3RYeeuKC5weXWEALOkG7AUcYJZ0A9JKNGpJN9CgMUxAGn46LOn2lX91MLzlYA5VgrmB43sT8PsAgHkV%2F31A%2FXJwaHIPmka6gG8CIWk8yl106HLQFjiYvWDBISQ43LZ%2BmDBuq18sDk3uTxNqYIaFpBk2zu7vs7vlpHiFwGbeA8xyz%2FBqNQ5xwWG57YMjjOUAFp9Dk%2FvghBr0wQlJN2zlO99CzMzcdWB6xiaHkOCA2%2FbJEQdu9YvSuPLOTHBr0CcnIu2rdDbWCtsH5ufacygJDLkj0pez5O6L3Oo7nEUmt9tptAuZ3KSBtf9%2B8dAOBtL4h0NncLhuq1uFcR1AG7XI5PJWjo2s1XGd9LJmy%2BmPNL%2Bd398%2BTZLy%2Bo5vizoDcOdWG8ZvecERSjjotOWn4tCpvmdaZHL9aaRB%2FSmeFVHRmb6kd8viF%2Bw0H5kaVo3GtmpUHDJZ%2B54JDC9pEplUlNSoFzI0SSNHfZvJvQ%2BGVM3EoS44PCddq695Ns%2Bz4nVnqAZUyUS0pqTkVjTYftOaMhQXMj0MHwB1TDH73uW765io4RX4hST9HqPqmGINLJ%2BYtHyg3n0HXn%2FEoaZf3HJ9ueqyrpMwflPqj2Tz22TTKdbAdMLjZzjrsAPZg4pDHGBYPLJ2ljAWU2qKJLN4RLpZ5rB4pIGXNSK9LPG1oEOp4eQQABTeIsemjwvjLa3uRy5wm%2BY9Zi4ftOqFi1zkkiMavMC6ylbZbx2hthnqk8YylSfCYJjqkqMc3JDsOl0sqhutdfIJJ99nTtkWGDk9Ohqod%2FJbjevTkQy5lKU11TfDHp38Vr2Q74bkWhkwJ3%2FYBj6PiKCsmSPXNi8Qhm3lDcSQa3Dvgla6kJlNro%2BpMfAb3z74p%2FkzHw5lwAGxdZOEgVh5R7Dm3cwEsQZWkkdaSYr7EBjeV4BHFWAgjL%2BVFsL9Q1h9Ky%2FkGdxXoNUuZAqTNtI4ea0qqJ7T9K9u5fxmZ6TwhBcOTvXI7tYTp8obbCHP4HL%2BVruQcUrZrVpam9uhcFe%2FXgDIs1nZ4rirvD0W8gxOy261C5i7%2BJWJjrRFJsDbvTn%2FXO1t%2Bv385uzy20174s%2FLL0YbCBxKAENeRNpMlrw9kVd9AyuEuvpDkMnLsfOsOvKSDk7VUlYId9cHQ6Uvhxrg0LfrviuWvrvpq7wHFkJd7STQ9GXPkVdHX9LwafKxx8s8YSqEGSxQ2QMMB6h6bDOsJ1CVd8hCqKtPBBqo8DcZRoh0cmbzIt3ZeVXcwUAKDXlUAYbCeORlKSyitEI5hX3SMzKp0LBRL2AO%2B6Svs0%2Bh4VAqCzlCCgei5NzlfJo8pDvjNKB6wsMYUxBXFI5Y66%2FdkbiI6TH5AFBR6HO351XeGxD55NzDqIpCX4Pph09OP4BVFDYHAy8t5FATmFp%2BnKAGnN8Api38%2FFbeGxAFXVe6Ic9ZGukChndAzlnKS5jeLvOJEk5jB8n1zHaQOLQBB8V6NOfQEsXKWwOigFz2NslACjTozRGQS9PT8jNPy4%2FW12YXeARsMFl76Z8hmay2f4YwsgJoAhiQHpRRaNWghUZAGkXT5eKuHOmK9CqGYuVzKAAKcwOKbWWZ2xdzKWWFcpkbUHwjg5jbqhcucwOKuVPt27aQs3HbQNjLowQo7EUByd6r%2BcSuopaPtHVheBXVDWg%2BbUwJWDPU7T9iIYlTiHdLAMuoAfv38RfLqLTwivs%2BhiSpjVpGbdQL926JQtKJt8uoIJdROdT0iztuIFdd1rsXxm%2FW27PA6HYtWQM81WmlCxnepHMPZIs10xdSOdQBBcaBtfvFwZi2kCoVxoHZbn%2BggdsfUNz%2BynmSYzxtO1DmwpdHC1DgiyJynvV5tRK0M1BDcp%2BaTYBwfSmlsomewh%2BKi5gecxcA3lOjbY1S%2BCPDNwWKNJi%2BROA3BWoOBu49cagJzGpPZKc7wvitPoU%2FMnl3oAj%2BZAdFUHYHag6w9xSabT1xiAMOi23WkzAWq8%2Fhx5M3M1kMP%2BUJxZQNgtLFXZ49MXU164Zb07vucAgADG9j0m2yvO2JtwAy%2B2PSmjLI62%2FVCxm5pH%2FUX9HUQJJIeQINB62kafW5DvzOUA3Jyifa8SBWs6BJ3xcQND28IABefsy%2BZQwYLz8mvSCjvPxYAzsoJu0g6%2BWD9PI51ATnpmv9I2H8Vu%2FlYwfLSP8o1sA%2FGpH%2BkfXyWdksSRxgWDwi7%2FTXRflBH4rH05c0v8sWNqepfMTHUcHzoCg4CthI22SOCgieHjdSABOhEfsOblAmQr5D3kiNmgiN4N9LfYe8lwKbCA18%2FsMhIij3XN%2Bx6znCsK18%2FuM7XTONAc9%2FWulCZja5mJOnTwp2smkOrs8ur0yu4eCRBRwKd93Dz1IYbhaT73RdIwJNYXZbUB2FyWWcksJpkVVJTLfLWVZ0MJKQZ7KRxBNfODjtuoOfxSngJCXf6Wo1geYpe0SU8RRvOb81qr3NZrd5ukjzn%2B8b%2FOYPQ9njCIabbtfdKyw3d3NTeQtRv9kH0kRuuuzrKOq4Sdoxz1lavbH42f%2FHy2%2FHF9WO4l%2BvTk%2FOr88vv5hMXw41wKFv16ZXlr676Rurp29Xjwc0fX3miKijL2nDPK%2FeeF8HYPNgIG4AR5zBcNXTI0VbS656rnKueka3J2vVC5isHmUzkk4lSwMpU%2BIJLhicdt7i0uJ0N0595TilbKBpEk4DDWwCyr6UKxmW3LldpItFtWhlsdpPkOFgldI2LrmzCc8HVdJyfdX3SHj2m6cKCJkeWRvqU55bcWuU8kxpam1SynOrXsh3QnJuByzl%2Bf277UCzoXn0BecmbBNHhBFdfTY0ZZc2gyY2GuSNUDZdU1wNSj0YiJfPoRgwgKZs7GYB3ROg1SdKU7aMMwfQoQbOE2VXtfLTpnmlQgBsNj5pkEMjcJBs01aEIRlAsjVlJziDmKxB2kpI%2BlCP88m4WgwYz59F9eA1H7UaZrKEXbcmsKiFnJ8ddnWfQKM2Yo6IOtSSBlGpwUUJHQij3wGxmV0rYNiMUWHZLIDN6rO3o67GE2Q2N9oFzGbKNpd4GLx8kslg4%2BnLoQY49NVjS00t6Qsgx5uyp6ZJSYkabKnpU7bUXNTNOW%2FTujsnY1biUNIQNdzb0qfsbfl7%2BnqT3j3Osr%2BX6enE7kexa2vpprz33e0oBIZPD4cIQEoix2aHYFISKTtjGpWSGGngEVE2nLQpiZqkJHLoC8wNufMWmIOZ2fATXX1KImV%2FTXOmNY10AeOcsp9lNVRNVSe84BxE1%2Bw9UHk0AgbJIz3qfrREsvokxBE5AzbJaxppUPYzImex%2FW2BOlw%2FiiP0UFgb4AS4DSmczsbLPJndpXZToIOdmwI1c53NL7FHDR0SFjs9kvXVm1GtyruYUTvCKyy65MjZJDMq4PgOqrpRBh657KmPGbXfwbAtLB5V%2FuIePpKrUlshIOw%2BQLGwZN8HDC4QaKUL%2BSZATljHWTnkLUfIEIDNeDCo%2FsQ8uoKDcT3WlrXEOMX2ko1xg4sPWulCxji5sIwx3keD4r4XJsxujsCjGDCAxq9sAd0%2FoGmVuJIJjQxeK261C5jQiHS8Kie62kQOCJxZDm7OP1fD7O%2FnN2eX327aE39efjk1megcCoNDdFvWII7olIJf2UTvaoyBJjr8ooYAkd4VJjqkMff6YCAjbw7dwOG03WJEHKcpxb%2ByOd3V%2BQLNafgbjASINKd%2BOt40ebl9SvMqryJ56N%2FrNr3QlyfycEjbtYerJe1O0tIKfSWTFmcxmUnaEXNElJHWJ02mx7S80LflqBjucqL5qGaXDhhU%2B6RdZlHdF6opG0XJRjXpTRmUJ9%2BqFzKsSf9IZJ78%2Ftl69Ulz%2BcyhFjh8tmVM4vgcqeez0XVMrXoh85n0jfrZyI%2FxYDD07aWwSS59WTajSccPKU4cLy9BVrxepZPV6sRp%2B8g6vXxd3OSWH%2Fn4sZhO6i9YOht%2FyPPVRT29miaz8eUqdKt6KNoD6UtW%2FBv%2Fbnn8nyp6R0H908cX%2FDWufnjFP8zK6%2FHv1RMdFOIT6990yk9Zn2h%2FefXTm9%2F%2BmuZZeVlX5VgONe71rHQxX%2BZ36S8uq%2BvWUijwfWjXMxHe66C6yKz4cB2KRpqT%2BSo4P9M3fzJNOfV7fK3uZAcbDYWwAvE%2Bhy6Kt%2FS3vgD1L7YSJF8LEa%2Flb7%2FW%2BhIRr7WSc%2FPxOyicZTcPIAqPEfq1xssfVIjUxdM8OCJtBkOtsPytHTbZReo4R9XunvifR0g2PvK2yhOFq5Yh5aJf1Za305v552T22hnAb%2BEbvIPeLgKOGQXs4batcATcdF9rZOaM9qbs9ku52y8lXK4MKSTi5Lq%2FhDzca%2F39GzUuMIIjIQoD3b0Z6G69Voy2Xqo%2FCd1ePd%2F%2F1%2F%2FLO7z7K%2FP%2B%2BPvjeXg8O5R%2Bl37Duz3ZhTnpHI1G4RtWuhJv5Owi9uIYmoj9bd2Fe0oYt5XY%2BUKCBaz0hr2%2FeBquvSse37HiESUepbfPfUZ7MgTXZIaAERwK39MJq%2BD8gBj%2Bbd%2B7BUuOIVcQ3g13p%2Bzen8PiFntgxNTWAnQfv1GGgqGwKQBVTgy5ieIJVo3D4rfjsHcmrZSBmIKJLLOKm9woOCr24yPXbc0T3H28EaKHu%2B%2FxajqKtjUdSEYkQy0yxCEdh5wQuCFd4B7F8aj5F0eEnEb7yWm0PVgcRXIJib%2B6qu%2B4Lcj%2B84ZjfVMNBSGjDBE8e84ob8VlSLGAN9ajT0siYfOSmHnNLoI2LzkMwy2J%2BdtwY1arG23NccLt1WfRapU%2BlGRZsNtcXo42hXxYDjIjd5%2F1Zbnz7sa%2Bed%2FoiaANMiPi3r2nuuPtFxK4UkIXt%2FQxJZe4Zc3GmywAMBI7DLcdmWauxSsydzvpgYCxaJFJT%2Bp5304Mw2j%2Fmbjbky7fhWTgM68HxuAGAcSYdbQ9zmQfsqKtQQCSLGGWps3KsnbI5b6YW9v7axTFrBpt6nXgaJQYqAbOnpTdFntTiyJLoR5EhWJilqNSx4neYrNOL%2BtnmOpKzVVj17zvuuA0H8Rbmkd7WqLbq0ZInCH6evGzuPoz%2BPbp8e9%2FPfzx%2B%2FNv%2F8tS%2BWtGPKmUpeD9txKtQrK3%2BX%2FkrH99Y57nuNE%2BX6AOsg8Qo%2Bxd3BwCjuwDd3Q02vi39SVwfRSUV3TfAUpQAW5nzmbU23Cl%2FDGfz4vNp%2BfJ0%2BPn%2BTitnvF%2F)

* Database structure graph:

## Planned features
* Create and login user
* User records system -> add record for given exercise or create your own record (f.e make a somersault)
* User achievements system -> get achievements for behaviour leading to progress (f.e train 3 x per week, beat old record)
* Exercise with description and images -> 2 types of exercises (endurance vs strength) and accordingly data (distance x time, reps x sets x weight)
* Calculate tonnage automatically
* Create training plan
* Add priority to training plan (focus on specified task/exercise/muscle)
* Create training session
* Inform, when tonnage in consecutive months are lower
* Infrom, when one training plan have too much specified muscle part dominance (f.e to much biceps workouts in one month/plan)
* Start/End training button (time counter)
* Add some informations about training sessions (f.e difficulty of exercise) after them
* Create up to date training plan - during the training
* Add own exercise
* JWT Token security
 
## Technologies and Tools
#### Backend 
* Java 11
* Spring Boot 2
* Hibernate
* JUnit 5, Mockito 2, AssertJ
* MySQL
* Cloudinary API
* REST
* SonarQube
* Swagger
 
#### Fronted
* React(Hooks)
* Redux
* Styled Components
* Jest
* React-testing-library
* Reac-router
* Axios

## Troubles
#### FAQ
 
## Contributors
1. [Damian Naglak](mailto:damiannaglak1@gmail.com) as [naslakboss](https://github.com/naslakboss) - concept, backend, project management, group formation
2. [Paweł Karpiel](mailto:pawel21599@gmail.com) - backend
3. [Przemysław Saja](mailto:przemyslawsaja@gmail.com) as [przemyslawsaja](https://github.com/przemyslawsaja) - frontend, concept
4. [Igor Chmielewski](mailto:igorchmielewski@gmail.com) - backend
5. [Agnieszka Dzierzkowska](mailto:aga.dzierzkowska21@gmail.com) - ui/ux
6. [Karol Kaczorowski](mailto:KarolKaczorowskiC.dev@gmail.com) as [KarolKaczorowski78](https://github.com/KarolKaczorowski78) - frontend
7. [Kamil Cecherz](mailto:cecherz@outlook.com) as [pangeon](https://github.com/pangeon) - update read.me

## License
