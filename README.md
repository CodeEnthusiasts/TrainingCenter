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
[Diagrams.net](https://viewer.diagrams.net/?highlight=0000ff&edit=_blank&layers=1&nav=1#R7Z1dU%2BM4FoZ%2FDVW7F1C25a9cNjQzUNPd9AI9vds3lJsY8E4SM47TwP76tRPLTiKFSLFlHcnqmto1TkiIz5vH0qtzjo7Q2fT19yx6fvqcjuPJkWONX4%2FQxyOn%2BBfYxf%2BVZ97wGeSuzjxmyXh1zm5O3CT%2Fi6uTVnV2kYzj%2BcYT8zSd5Mnz5sn7dDaL7%2FONc1GWpS%2BbT3tIJ5vv%2Bhw9xsSJm%2FtoQp79nozzp%2Bqs7Y%2BaBy7i5PGpeuvQ8VcP%2FIzu%2F3rM0sWser8jBz0s%2F60enkb4taoPOn%2BKxunL2il0foTOsjTNV0fT17N4Ul5cfNlWv%2FfbjkfrvzuLZznLL6DT0%2Bml%2Fed35%2BL7%2FPzj8ePvFx%2BOj20rXL3Or2iyqK7It3mczau%2FOX%2FD16n485%2FLwzz6WZ46nedRllfhRFZxoghQHiWzOCtO2MufJ5PoeZ4sn74685RMxp%2Bit3SR4xfCP50%2BJK%2Fx%2BHoVzfK5RWA%2FFS9W%2Fli%2B%2BEPx4jfVH1M%2BHE2Sx1lxfF98%2BPIdT7N4Xvwtn6J5Xj2DvDzVFfsVZ3n8unaquly%2Fx%2Bk0zrO34inVo8ehVcWuEvex7fnVmZdGK05QnXtak4kdViejSp%2BP9cs3MSoOqjBxhWxEhGxntIrPnyfR5Lr45kSzx2XgNuNSXtxxlj7fRtljnFcnntOkvKznv4prV0cgmUzO0klahneWzspXytPn6sFJ%2FIB%2F92ea5%2BkUR7G6IPWLLi%2BGd1r8V1yeM%2BvEO%2FKKP%2Fes%2BNlufi7%2BK5%2Be5WfpbJ5nhajK14iL2L7EZXwpsd0j7v0hryKMGMOLhEUXc3Etul%2F%2F4IvvEpRRE1%2Fu0Flbodv%2B9qXFBX2YLGH2lIzH8YwnJiPmmKwFAfUbA5uIQfELZ87Rh%2BItLXEHp5e%2FX365LQ6%2BXC3%2F99unT5Ijjzm7eu7p%2FDm6T2aPn1a%2F6W9Jw%2BtPGq%2B7v65uv1JxlIDxdlyVgDHrvVZgdFHL6Hb%2BhYzHCX69tiSupQuZxC4RgEUxPJ1F05idrH9%2BuD67%2BHD9D%2BT8c8VWFcDaU2ThgNQzIBUF0pF8kPo6g9RjDog8kAZEAJ6j%2BfwlzfgGtsNjKXtw4bCUNHUMSztiqe3Ih2lbAwg0TNkjIg2mWAJrAYinUTLp1hDAqA2toaCWPfRgUOuQVpFBbVeo9aSjFkdTS9RyrIjIQy3pwJhxa8fBhQNTcpJSLkZ%2BjPPi5mqWJItHjhE2RfGS5Mj12CDpiFuRdNSYbwBYkawVrtCKpENON7RakXQUmHHgV%2B57RXLXwcBXKjkkA%2BbmisxMRRik5a9UIp0nKkiBiQoiJyovqzcWhuKPV99OP51D525PgYfDWXLJ2nC2I87KX8hEbZepQXPWZQ6IPM6SK8llhnfvI%2BCbi6vrW63Zyy4GOOwlDSTD3o7YC2DhE7X1mUDDlz0i8uBLWkHz4m%2FtHb7rbv72UzQmMrtCwBAZv5shsgAiy18fdduaSpCJXGsXMJFd0vdZvfG3WdLWethYM9UXqxxhhoPVtvm0Bqu7sRrKx2rbeQxorPrMEZGHVXKm8TMdv33fi9ahMJM9hnCYqUbdtJLMrNs5yGMmHgyvhfc32WkKXVJTgbppj1I3PY0e47uOchXWsw5USDnoKd5QCIvctuWyhrC7CevKJixyyZVNjQjbqBcuYZFLLj%2BW9dBdAXb9YECw5Qk9FNjaASmF89l4kUWz%2B7iIRZkgvytiA0qYDnFQ6hZOLmV6j2ihE5gwHahh3wBImA7Yy293J0xTwyvwm0m6N1olTAcKGDgBaeBITZg%2B4KZ7NLy8ag5l7b4PI7tfpRlbSRjLKXnVPbMcjwG0dOIDBTylkPSUxlEuIeHv%2FYOPH261zsTmkAoYMoeOIbMoMlMysfsms869%2BWrpQiYzaQeOk3le%2Bg9yEFyVw1hfr8%2FPLm8ur77oDGQOhcABsunxJwzItPTsvomsc5O%2FUIEmfyFpPGEi3y3a5wMONkOQI%2FZwWKtGTw41WUtJvO6btTr3AAwV6MiBJ0DrrF1kUZ6kMymj39vLz%2BXY9%2Fvl7cXVt9vmxI%2BrL%2Bf6l8ZwKAYMoUemIYc4QrMu8goMb1v3CTKhR%2BwL8fIITRpE0%2BIzT4uPdse3gQBtyOtZWg95OQIMB6im84YwoNISvPsGqs6tN0YKtN4Ykf5OnkwFWQtcNeA6g7iLNhx9g9i04RAHYkoeeN8gJq0ljfLAG%2FVCRjFp%2F4jKAz%2BsPOdIjeS1nnQChcwO3tAWzhiqoxAd0EkbWwQ4M5xW9t0rWB1Lj24a%2FLFw7f2x6BWwjkWaBzd58REf8ydTXLG7uMK2yG70yKFETlxxhWOpYQPIL65oRN6quIIWXoFfTNIF0Km4olEv3NGnY5FGgCmugF5cwaOsd4ocR%2F0qzTgJwlhOK67omeUa9%2FNspAsZ5KSNYIorencSeKQChsx4xmbI3D2ZacUV%2FZLZ1sOJ2CNdwGS2HSIAWfw8BwLk%2BkD3Lvg8WoGDZtOGSRiaqWUWPbO5rb8Fms3wmzA5NmlBFWyO86RM%2Fu00G2IYOQ48QYcDWTVa%2BKgJWVp9Rc%2BQ1bgDc6NdyJAlvSHR%2B%2BmZIuMWQoEDZtOPRxyYaevy%2FYIZv5ueYIbfkKdJE9gGs%2BA84KGMhTvp%2B9wvcvFX0CC3e%2BRSCy96Rq7GnXYa7UJGLun4tK1kG0YZG0904dDUdMkRR1Na9UTPNCWNI42qJxr1QuYpae7Aqp5QITWtJ5GAwTIi5z1ni3lx8Uw%2B%2BM588CBgxG3dTkVA3NSYnABIB0fsAQeTDo7IuYlW6eC1egHfThE5PTHp4ODTwTmUBecebKZGwlguPx0cadw%2FtJEuZJBT%2BoeadPDeZ0ccUoFDZtNuVBiZ5aeDI427jTbSBUxmPLFeJ3M8v8%2BS554ajuL1AtvSe8GAQwxg2OuaRqLC2Asg39tta2BBhq%2FLHhF58CU9ptUhkOHwoFISOQQDBtCeKcgRB2j5ueKe1vuiN%2BoFjGivv33Rtw%2FYDGYV3OWeRAIHy6TfeFuyq7gqXyfRbGe4BrSie4ywLYyXdH2Llbe2uMCp0RUGwJKux17AAWZJ1yOtRK2WdD0FGsN4pOGnwpJuV%2FlXR8NbDuZQJZgbOL43Ab8PAJhX8d8H5C8H%2Bzr3oKmlC%2Fgm4JPGY7%2BLDm0OmgIHvRcsOIQEh9vGDxPGbfmLxb7O%2FWl8BcwwnzTDxsnDQ3K%2FmORvENjMe4BZ7mhercYhLjgsN31whLEcwOKzr3MfHF%2BBPjg%2B6YYtfec7iJmZuw50z9jkEBIccJs%2BOeLALX9RGlfe6QluBfrkBKR9Fc%2FGSmH7SP9cew4lgSF3QPpyhtxdkVt%2Bh7NA53Y7tXYhk5s0sA7fLx7awUAa%2F3DoDA7XTXWrMK4DaKMW6FzeyrGRtTyuk17WbDH9GWd36cPd8yQqru%2F4Lq8yAHdutaH9lhccoYSDTlN%2BKg6d8numBTrXnwYK1J%2FiWREVnfFrfL%2FI32Gn%2FshUsGo0NFWj4pDJ2vdMYHhJk0inoqRavZChSRo58ttMHnwwpGomDnXB4TnpWn3NkjRL8redoRpQJRPRmpKSW1Fje6M1pS8uZGoYPgDqmEL2vct31zFRwyvwC0n6PVrVMYUKWD4haflAvfsOvP6IQ03v3HLdftVlXCdh%2FKbUH%2FXNb51Np1AB0wmPn%2BGsww5kDyoOcYBh8cjYWcJYTKkp6pnFI9LN0ofFIwW8rBHpZYmvBR1KDSeHAKDwFlkmfVwYb2l1P%2F0Ct27eo%2BfyQaNeuMhFNjmiwQusy2yVw9YRKpuhOqktU3kiDIapNjnKwQ3JbuL5vLzRGiefcPJd5pRtgZFTo6OBfCe%2F0bg6HcmQTVlak30z7NDJb9QL%2BW5IrpUBc%2FKHbeDziAjKmjmyTfMCYdiW3kAM2Rr3LmikC5nZ5PqYHAO%2F9u29f%2Bo%2F8%2BFQBhwQGzdJGIildwSr301PECtgJTmklSS5D4HmfQV4VAEGwvhbaSDcPYTlt%2FJCjsZ9BRrtQqYwaSONo7eyguoljv9qV86vd0YKT3jh4FSN7G41cSq9wRZyNC7nb7QLGaeU3ap7a3M7FO6q1wsAOSYrWxx3pbfHQo7GadmNdgFzF78y0ZE2TwR4u7eXn8u9Tb9f3l5cfbttTvy4%2BqK1gcChBDDkRaTNZMjbEXnlN7BCqK0%2FBJm8HDvPyiMv6eCULWWFcHd1MFT6cqgBDn3b7rti6LubvtJ7YCHU1k4CTV%2F2HHl59CUNnzofe7zIIqZCmMEClT3AcICqxjbDagJVeocshNr6RKCBCn%2BTYYRIJ2eW5vHOzqviDgZSaMijCjAUxiMvQ2ERpRXSKeySnpFOhYa1egFz2CV9nUMKDYdSWcgRUjgQJecul9PoMd4ZpwHVEx6HmIK4onDEWn9tj8RFTI3JB4CKQpe7Pa%2F03oDIJeceWlUUugpMP1xy%2BgGsorA%2BGHhpIYeawNTy4wQ14PwGMG3h57f03oDIa7vSDXnOUksXMLw9cs5SXML4bpFNpHAaO0i2o7eDxKENOChWozmHkiiW3hoQeeSyt04GkqdAbw6PXJqeFp95Wny0rja7wCNgjcnaSf%2BMnslq%2BmcIIyuAJoAe6UFphVYFWmh4pFE0Xczvi5GuSK9iKFY%2BhwKgMNej2FaGuV0xl1JW2C9zPYpvpBFzG%2FXCZa5HMXfKfdvm%2FWzcNhD28igBCnuRR7L3Op2YVdTikaYuDK%2Bi2h7Npw0pAauHut1HzCdxCvFuCWAZ1WP%2FPr6zjEoLr7jvo0%2BSWqtl1Fq9cO%2BWyCedeLOMCnIZlUNN79xxvX7VZbx7YfxmvT0LjG7bkjXAU51GupDhTTr3QLZY030hlUMdUGDsGbtfHIxpC6m9wtjT2%2B33FHD7PYrbXzpP%2FRhP2w6UvvDl0QIU%2BKKAnGd9Xq4E7QzUkNynehMgXF9KqWyip%2FD74iKmxtwFgPdUa1uhFP5A802BAgWmLwH4TYHqg4F7TxxqArPaE5jpjjB%2By0%2FhD3TeHSiAP9lBAZTdgeoD7D35eltPHOKAw2KT9SSMxfJz%2BPHkTU8Ww095QiFlg6B4fp8lz0xdzdrhVveuOxwCAMPbkHSbDG874i2AzP6QtKY08vob9UJGLukfdVc0NZAkUp5Aw0EraVp9rgK%2FM1RDsvKJdjyI1Syo0%2FcFBE0NLwiAlx%2BybxkDxssPSS9IKy8%2FVMAOCkk7yHj5IL18DjXBueka%2F0gYv%2BV7%2BdjB0tI%2FChXwj0akf2S8fFY29yQOMCwekXf6m7z4oI%2F50%2FlrnN0nc5PTVDzi4qjgeVDgnXhspK0zRwUET40bKYCJ0Ih9BzcoEyHXIm%2BkWk2ERvDvpa5F3kuBTYQGPv%2FhEBGUe65rmfUcYdiWPv9xrbaZxoDnP410ITObXMzJ4mcJO9nUBzcXV9c613DwyAIOhdvu4WcoDDeLybXarhGBpjC7LSiPwuQyTkHhOE%2FKJKa7xSzJWxhJyNHZSOKJLxyctt3Bz%2BAUcJKSa7W1mkDzlD0i0niKt5zfGtXeJbO7LJ7H2a%2F9Br%2F%2Bw1D2OILhpt129wrDzd3clN5C1K33gdSRmzb7Ooo8bpJ2zEsSl28sfvb%2F8erb6adyR%2FGv1%2BdnlzeXV190pi%2BHGuDQt23TK0Pf3fQN5dO3rccDmr4uc0Tk0Ze0YV6Wb3yoA7B%2BMBA3gCPOYLjqqJGirSRXHVs6Vx2t25M16gVMVoeyGUmrkqWBlCnxBBcMTltvcWlwuhunrnScUjbQ1AmnngI2AWVfyqUMC%2B7czeP5vFy0WsPqUGDJETo4sKQ0g4vuTRrzUZmKXF31A9KY3fqpAkKmRi6G%2FETmRtwKJTJTWlXrlMjcqBfy%2FY2csQFLZN4%2FNRlojjOPvuDchE06iDCiy89xpuy9ptF0RYFsEMpWapJrPKkHA3HoORQDBtCU7doMoDsCtPz0Z8pGcPoA2lfAT6LslVZ82jgrVQiAzdqnAnJoBA6STTKKMCQDSKGm7O%2BmEZMVSEbxSR%2FqKZ2MS4t%2FnL6I6qyrP2oVzE%2Fx2244YFALOevab%2Bs%2BgUZtwBwReaglDaJCg%2FMCOhBGvwNiM7tWwLAZo8KwWQCb5edkB22NJ8hsrrULmM2UzSvxMHjx3CeDtacvhxrg0FeNjTKVpC%2BAzG3KTpk6pRoqsFGmS9koc1613LyLq56bjCncQ0lDVHDHSpeyY%2BUf8dttfP80S%2F5exOcTs8vErg2j66LdvZtMCAyfGg4RgJREji0MwaQkUva71ColMVDAI6JsI2lSEhVJSeTQF5gbcuuNLQczs%2BEnuvyURMqumfpMa2rpAsY5ZZfKcqgay054wTmItt47m%2FJoBAySR2rU%2FSiJZPlJiCNyBqyT1zRSoOxnRM5iu9vYdLh%2BFEfoobDWwwlwa1I4n40XWTS7j81WP0c7t%2Fqp5zrrX2KHGjokLHZqJOvLN6Malbcxo3aEV1h0yZGzTmaUx%2FEdlHWj9Bxy2VMdM%2Bqwg2FbWDyqfOcePupXpaZCQNh9gGJh9X0f0LhAoJEu5JsAOWEdJ8WQtxghQwA248Ggug7z6AoOxtVYW1YS4xTbq2%2BMa1x80EgXMsbJhWWM8S7aDne9MKF3cwQexYABNH5lA%2BjuAU2rxO2Z0EjjteJGu4AJjUjHq3Siy63hgMCZ5eD28nM5zP5%2BeXtx9e22OfHj6su5zkTnUBgcopuyBnFEpxT89k30tsYYaKLDL2rwEOldYaJDGnOvDgYy8ubQDRxOm41DxHGaUvzbN6fbOl%2BgOQ1%2F2xAPkebUL8uZRq93z3FW5lVEj9173boX%2BvJEHg5p2%2FZwNaTdSVpaoW%2FPpMVZTHqSdsQcEWmkdUmT6SkuLvRdMSqGu5yoP6rZpQMG1S5plxlUd4VqyvZPfaOa9KY0ypNv1AsZ1qR%2FJDJP%2FvBsveqkvnzmUAscPpsyJnF8DuTzWes6pka9kPlM%2Bkbvbc%2FX%2BcFg6NtJYVO%2F9GXZjCYeP8Y4cby4BEn%2Bdh1PlqsT580jq%2FTyVXGTXXzk06d8Oqm%2BYPFs%2FCHLlhf1%2FHoazcZXy9At66FoD8SvSf5v%2FLvF8X%2FK6J141U8fX%2FHXuPzhDf8wK67Hv5dPtJCPT6x%2B0yo%2BZXWi%2BeXlTxu%2F%2FTXOkuKyLsuxLGrcq1npPF1k9%2FE7l9W2Kynk%2BD6065kI73VQXmRWfNgWRSP1yWwZnF%2Fxxp9MU071Hl%2FLO9nRWkMhrEC8z6GNwi39rS5A9YuNBMnXQsRruduvtbpExGst5Vx%2F%2FBYKZ9nNA4jCQ4Te13jxgwyR2niaB0ek9WCoEZa7tcMmu0gt66Tc3RP%2FcwjJhifOVnmicNUypFx0q9ridnqbfo5mb60BvAlfbw962wg4ZBSwg9u2whFw3X2tlpk1Opiy2y9lb7%2BUcLkypJCIk%2BvhEnJwr%2FX9N2pcYARHQhQG2gcz0N56rRBtvVR3Erq7fnn4r%2FuXc3z%2FV%2BL8%2BffHS%2F90dtz7XXqDdweyC3PSOhmN%2FA1W2j3eyNlF7IQhNBG727rzD5Qwbiux84UEC1jqDftw8dRc2yse1zLiESUeqbfPQ0Z7fQiuzgwBIzjk79MJq%2BBcjxj%2Bbd%2B7BUuOIVcQ7g13U6rOgVrdP%2FHFffm2FLgp83%2FdJp6deg%2FHf%2F%2B6TX77kc3vLpJjyUolfBfHOnB2QRll%2BsJmF1SlMqQ9woKj0KkwVW0Oo6Dr3CowSD12wxPbbswX3L28ES7u3scr3CDYFq7XM2IZaplhCfdwATI7MQjcINKzT8JwVP8LA0KAo8MEONoeno6CfsGJv%2Byy7%2FEN%2BP6zwb2uDUHk%2BYwyRPAMQa3cHJshqUOV0WUgbCYUMq8SBtBmQse%2BvyUxdxtuzGq1g61Zlb%2B93i1arb2PMFmWCNcXtIN1IR9bJ3ZgH7Ki3e9MvzaM9ltLAbRhaUDcuw9Ud7j9QgLXZuji7n0UyiXujmZI%2ByUWQpPYsb%2FtAdWzM16R2dvTfQLGokXWexrR%2FqmO7wfcizC1Lu2OdLkXkp7LvAIZghsEEGPW0fY4k33IirYGAahnCbO0iZaWJ0QuMIY9LjCikFWjdYUQHI0SA1XvUCd0W%2Bx19UtfCnUgKhQTsxiVWlawic0qoa2bYarda3Ycu%2BZd2waneS%2Fc0jw60ETdXqdC4izUt0%2B%2F8usf3rffn%2F7%2B1%2BOff7z89r8k7n%2BViid5sxC8uynRMiSHDjmK78%2Fq19fmeZYdHPIFaiF7DzHK3sbtKODI3rNHJ6O1f1tfAttFXnFFDx2geCXgdmaJBuKGK7vXFze3PYizeTpbllCk2XhOfE%2FU3I6EKKag6JqUXDOqJExVLLb1mouQosrtafohNRfvrdUBr3cTvh3JnsDyLKrv3oyEGtkuqmmofx6ZAqbQViSHxMPZC3xRlW7UP4fMooJRfkweaL19SIdKeqdOzutTWW27kmtSo9w9s2l73%2FbKbNK4VKc8%2BZBwhLCQTUlRWMzjrOe%2BERjHsAncixCgENdWy47dM%2B9vkZBAn9sTCamdFdAdONBTqdxzdDJy1jIOt1%2B5y3LP4scsTfP1p2fR89PndByXz%2Fg%2F)

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
1. [Damian Naglak](mailto:damiannaglak1@gmail.com) as [naslakboss](https://github.com/naslakboss) - concept, major backend backend, project management, group formation
2. [Agnieszka Dzierzkowska](mailto:aga.dzierzkowska21@gmail.com) - ui/ux
3. [Przemysław Saja](mailto:przemyslawsaja@gmail.com) as [przemyslawsaja](https://github.com/przemyslawsaja) - major frontend contributor, concept
3. [Paweł Karpiel](mailto:pawel21599@gmail.com) - major backend contributor, project overview advices
4. [Karol Kaczorowski](mailto:KarolKaczorowskiC.dev@gmail.com) as [KarolKaczorowski78](https://github.com/KarolKaczorowski78) - major frontend contributor
5. [Igor Chmielewski](mailto:igorchmielewski@gmail.com) - advices, abstraction foundation
6. [Kamil Cecherz](mailto:cecherz@outlook.com) as [pangeon](https://github.com/pangeon) - update read.me

## License
