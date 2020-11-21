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
[Diagrams.net](https://viewer.diagrams.net/?highlight=0000ff&edit=_blank&layers=1&nav=1#R7Z1rU%2BM4FoZ%2FDVW7H6Bsy9ePDc001NBNL5fp3flCuRMD3smFcZwG9tevnVh2iBSQYss6ktU1tWuckBCfN4%2BlV%2BccHaCT6cuXLH56%2FDofJ5MDxxq%2FHKDPB07xL7CL%2FyvPvOIzyF2fecjS8fqc3Zy4Tv%2BXVCet6uwyHSeLN0%2FM5%2FNJnj69PTmaz2bJKH9zLs6y%2BfPbp93PJ2%2Ff9Sl%2BSIgT16N4Qp79kY7zx%2Bqs7UfNA2dJ%2BvBYvXXo%2BOsHfsajvx6y%2BXJWvd%2BBg%2B5X%2F9YPT2P8WtUHXTzG4%2Fnzxil0eoBOsvk8Xx9NX06SSXlx8WVb%2F95vOx6t%2F%2B4smeUsv4COj6fn9h8%2FnLMfi9PPhw9fzj4dHtpWuH6dX%2FFkWV2R20WSLaq%2FOX%2FF16n485%2FKwzz%2BWZ46XuRxllfhRFZxoghQHqezJCtO2KufJ5P4aZGunr4%2B85hOxhfx63yZ4xfCPx3fpy%2FJ%2BGodzfK5RWAvihcrfyxf%2FL548evqjykfjifpw6w4HhUfvnzH4yxZFH%2FLRbzIq2eQl6e6Yr%2BSLE9eNk5Vl%2BtLMp8mefZaPKV69DC0qthV4j60Pb8689xoxQmqc48bMrHD6mRc6fOhfvkmRsVBFSaukEVEyHZGq%2Fj8eRpPropvTjx7WAXubVzKizvO5k83cfaQ5NWJp3laXtbTX8W1qyOQTiYn88m8DO9sPitfKZ8%2FVQ9Oknv8uz%2FneT6f4ihWF6R%2B0dXF8I6L%2F4rLc2IdeQde8eeeFD%2Fbzc%2FFf%2BXTs%2FxkPlvkWSGq8jWSIrbPSRlfSmw%2FEPfHIa8ijBjDi4RFF3NxI7rff%2BeL7wqUcRNf7tBZW6Hb%2FvbNiwt6P1nB7DEdj5MZT0wi5phsBAH1GwObiEHxCyfOwafiLS1xB8fnX86%2F3RQH3y5X%2F3t7cSE58piz6%2BceL57iUTp7uFj%2Fpr8lDa8%2Fabzs%2Frq6%2FUrFUQLG23FVAsas91qB0UUto9v5FzIZp%2Fj12pK4li5kErtEAJbF8HQWTxN2sv7x6erk7NPVP5DzzzVbVQBrT5GFA1LPgFQUSCP5IPV1BqnHHBB5IA2IADzFi8XzPOMb2A6PpezBhcNS0tQxLO2IpbYjH6ZtDSDQMGWPiDSYYglsBCCZxumkW0MAoza0hoJa9tCDQa1DWkUGtV2h1pOOWhxNLVHLsSIiD7WkA2PGrR0HFw5MyUlKuRj5OcmLm6tZkiweOUTYFMVLkpHrsUHSEbci6agx3wCwIlkrXKEVSYecbmi1IukoMOPAr9z3iuSug4GvVHJIBszNFZmZijBIy1%2BpRDpPVJACExVETlSe128sDMWfL2%2BPL06hc7enwMPhLLlkbTjbEWflL2SitsvUoDnrMgdEHmfJleQyw7v3EfD12eXVjdbsZRcDHPaSBpJhb0fsBbDwidr6TKDhyx4RefAlraBF8bf2Dt9NN3%2F7KRoTmV0hYIiM380QWQCR5a%2BPum1NJchErrULmMgu6fus3%2Fh2lra1Ht6smeqLVY4ww8Fq23xag9XdWA3lY7XtPAY0Vn3miMjDKjnT%2BDkfv%2F74EK1DYSZ7DOEwU426aSWZWbdzkMdMPBjeCO9vstMUuqSmAnXTHqVueho%2FJHcd5SpsZh2okHLQU7yhEBa5bctlDWF3E9aVTVjkkiubGhG2US9cwiKXXH4s66G7AuzmwYBgyxN6KLC1A1IKp7PxMotno6SIRZkgvytiA0qYDnFQ6hZOLmV6j2ihE5gwHahh3wBImA7Yy293J0xTwyvwm0m6N1olTAcKGDgBaeBITZje46Z7MLy8ag5l7b4PI7tfpRlbSRjLKXnVPbMcjwG0dOIDBTylkPSUxnEuIeHv%2FYPPn260zsTmkAoYMoeOIbMoMlMysfsms869%2BWrpQiYzaQeO00Ve%2Bg9yEFyVw1jfr05Pzq%2FPL7%2FpDGQOhcABsunxJwzItPTsvomsc5O%2FUIEmfyFpPGEi3y3b5wMONkOQI%2FZwWKtGTw41WUtJvO6btTr3AAwV6MiBJ0CbrF1mcZ7OZ1JGvzfnX8ux74%2Fzm7PL25vmxJ%2BX3071L43hUAwYQkemIYc4QrMu8goMb1v3CTKhI%2FaFeHmEJg2iafGZp8VHu%2BPbQIA25PUsrYe8HAGGA1TTeUMYUGkJ3n0DVefWG5ECrTci0t%2FJ06kga4GrBlxnEHfRhqNvEJs2HOJATMkD7xvEpLWkUR54o17IKCbtH1F54PuV5xyokbzWk06gkNnBG9rCGUN1FKI9OmljiwBnhtPKvnsFq2Pp0U2DPxau%2FXEsegWsY5HmwXVefMSH%2FNEUV%2BwurrAtshs9ciiRE1dc4Vhq2ADyiysakbcqrqCFV%2BAXk3QBdCquaNQLd%2FTpWKQRYIoroBdX8CjrnSLHqF%2BlGSdBGMtpxRU9s1zjfp6NdCGDnLQRTHFF704Cj1TAkBnP2AyZuyczrbiiXzLbejgRH0gXMJlthwhAljwtgAC5PtC9Cz6PVuCg2bRhEoZmaplFz2xu62%2BBZjP8JkyOTVpQBZuTPC2TfzvNhhhGjgNP0OFAVo0WPmpCllZf0TNkNe7A3GgXMmRJb0j0fnqmyLiFUOCA2fTjEQdm2rp8v2DG76YnmOE35GnSBLbBLDgPeChj4U76PveLXPwVNMjtHrnUwouekatxp51Gu5CRSzo%2BbSvZhlHGxhNdODQ1XXLE0ZRWPdEzTUnjSKPqiUa9kHlKmjuwqidUSE3rSSRgsIzIec%2FJclFcPJMPvjMfPAgYcVu3UxEQNzUmJwDSwRF7wMGkgyNybqJVOnitXsC3U0ROT0w6OPh0cA5lwbkHm6mRMJbLTwdHGvcPbaQLGeSU%2FqEmHbz32RGHVOCQ2bQbFUZm%2BengSONuo410AZMZT6w3yZwsRln61FPDUbxeYFt6LxhwiAEMe13TSFQYewHke7ttDSzI8HXZIyIPvqTHtD4EMhweVEoih2DAANozBTniAC0%2FV9zTel%2F0Rr2AEe31ty%2F69gGbwayCu9yTSOBgmfQbb0p2FVfl%2BySe7QzXgFZ0DxG2hfGSrm%2Bx8tYWFzg1usIAWNL12As4wCzpeqSVqNWSrqdAYxiPNPxUWNLtKv%2FqYHjLwRyqBHMDx%2Fcm4PcBAPMq%2FvuA%2FOVgX%2BceNLV0Ad8EfNJ47HfRoc1BU%2BCg94IFh5DgcNv4YcK4LX%2Bx2Ne5P42vgBnmk2bYOL2%2FT0fLSf4Kgc28B5jljubVahzigsNy0wdHGMsBLD77OvfB8RXog%2BOTbtjKd76DmJm560D3jE0OIcEBt%2BmTIw7c8helceWdnuBWoE9OQNpXyWysFLYP9M%2B151ASGHIHpC9nyN0VueV3OAt0brdTaxcyuUkDa%2F%2F94qEdDKTxD4fO4HDdVLcK4zqANmqBzuWtHBtZy%2BM66WXNltOfSXY3v797msTF9R3f5VUG4M6tNrTf8oIjlHDQacpPxaFTfs%2B0QOf600CB%2BlM8K6KiM3lJRsv8HXbqj0wFq0ZDUzUqDpmsfc8Ehpc0iXQqSqrVCxmapJEjv83k3gdDqmbiUBccnpOu1fcsnWdp%2FrozVAOqZCJaU1JyK2psv2lN6YsLmRqGD4A6ppB97%2FLddUzU8Ar8QpJ%2Bj1Z1TKEClk9IWj5Q774Drz%2FiUNM7t1y3X3UZ10kYvyn1R33zW2fTKVTAdMLjZzjrsAPZg4pDHGBYHBk7SxiLKTVFPbM4It0sfVgcKeBlRaSXJb4WdCg1nBwCgMJbZJn0cWG8pdX99AvcunmPnssHjXrhIhfZ5IgGL7CuslX2W0eobIbqpLZM5YkwGKba5CgHNyS7ThaL8kZrnHzCyXeZU7YFRk6NjgbynfxG4%2Bp0JEM2ZWlN9s2wQye%2FUS%2FkuyG5VgbMyR%2B2gc8jIihr5sg2zQuEYVt6AzFka9y7oJEuZGaT62NyDPzat%2Ff%2Bqf%2FMh0MZcEBs3CRhIJbeEax%2BNz1BrICV5JBWkuQ%2BBJr3FeBRBRgI42%2BlgXD3EJbfygs5GvcVaLQLmcKkjTSOX8sKquck%2BatdOb%2FeGSk84YWDUzWyu9XEqfQGW8jRuJy%2F0S5knFJ2q%2B6tze1QuKteLwDkmKxscdyV3h4LORqnZTfaBcxd%2FMpER9o8FeDt3px%2FLfc2%2FXF%2Bc3Z5e9Oc%2BPPym9YGAocSwJAXkTaTIW9H5JXfwAqhtv4QZPJy7Dwrj7ykg1O2lBXC3fXBUOnLoQY49G2774qh7276Su%2BBhVBbOwk0fdlz5OXRlzR86nzs8TKLmQphBgtU9gDDAaoa2wyrCVTpHbIQausTgQYq%2FE2GESKdnNk8T3Z2XhV3MJBCQx5VgKEwHnkZCosorZBOYZf0jHQqNKzVC5jDLunr7FNoOJTKQo6QwoEoOXc5n8YPyc44Daie8DDEFMQVhRFr%2FbUdiYuYGpMPABWFLnd7Xum9AZFLzj20qih0FZh%2BuOT0A1hFYX0w8NJCDjWBqeXHCWrA%2BQ1g2sLPb%2Bm9AZHXdqUb8pylli5geHvknKW4hMndMptI4TR2kGxHbweJQxtwUKxGcw4lUSy9NSDyyGVvnQwkT4HeHB65ND0tPvO0%2BGhdbXaBR8Aak7WT%2Fhk9k9X0zxBGVgBNAD3Sg9IKrQq00PBIo2i6XIyKka5Ir2IoVj6HAqAw16PYVoa5XTGXUlbYL3M9im%2BkEXMb9cJlrkcxd8p92xb9bNw2EPbyKAEKe5FHsvdqPjGrqMUjTV0YXkW1PZpPG1ICVg91u4%2BYT%2BIU4t0SwDKqx%2F59fGcZlRZecd9HnyS1VsuotXrh3i2RTzrxZhkV5DIqh5reueN6%2FarLePfC%2BM16exYY3bYla4CnOo10IcObdO6BbLGm%2B0IqhzqgwNgzdr84GNMWUnuFsae32%2B8p4PZ7FLe%2FdJ76MZ62HSh94cujBSjwRQE5z%2Fq6WgnaGaghuU%2F1JkC4vpRS2URP4ffFRUyNuQsA76nWtkIp%2FIHmmwIFCkxfAvCbAtUHA%2FeeONQEZrUnMNMdYfyWn8If6Lw7UAB%2FsoMCKLsD1QfYe%2FL1tp44xAGHxSbrSRiL5efw48mbniyGn%2FKEQsoGQclilKVPTF3N2uFW9647HAIAw9uQdJsMbzviLYDM%2FpC0pjTy%2Bhv1QkYu6R91VzQ1kCRSnkDDQStpWn2tAr8zVEOy8ol2PIjVLKjT9wUETQ0vCICXH7JvGQPGyw9JL0grLz9UwA4KSTvIePkgvXwONcG56Rr%2FSBi%2F5Xv52MHS0j8KFfCPItI%2FMl4%2BK5t7EgcYFkfknf46Lz7oQ%2F54%2BpJko3RhcpqKR1wcFTwPCrwjj420deaogOCpcSMFMBGK2HdwgzIRci3yRqrVRCiCfy91LfJeCmwiNPD5D4eIoNxzXcus5wjDtvT5j2u1zTQGPP9ppAuZ2eRiTpY8SdjJpj64Pru80rmGg0cWcCjcdg8%2FQ2G4WUyu1XaNCDSF2W1BeRQml3EKCid5WiYx3S1nad7CSEKOzkYST3zh4LTtDn4Gp4CTlFyrrdUEmqfsEZHGU7zl%2FNao9i6d3WXJIsl%2BfWzw6z8MZY8jGG7abXevMNzczU3pLUTdeh9IHblps6%2BjyOMmacc8p0n5xuJn%2F58vb48vyh3Fv1%2Bdnpxfn19%2B05m%2BHGqAQ9%2B2Ta8MfXfTN5RP37YeD2j6uswRkUdf0oZ5Xr3xvg7A5sFA3ACOOIPhqqNGiraSXHVs6Vx1tG5P1qgXMFkdymYkrUqWBlKmxBNcMDhtvcWlwelunLrScUrZQFMnnHoK2ASUfSlXMiy4c7dIFoty0WoDq0OBJUfo4MCS0gwuHpk05oMyFbm66nukMbv1UwWETI1cDPmJzI24FUpkprSq1imRuVEv5PsbOWMDlsj88dRkoDnOPPqCcxM26SDCiC4%2Fx5my95pG0xUFskEoW6lJrvGkHgzEoedQDBhAU7ZrM4DuCNDy058pG8HpA2hfAT%2BJslda8WmTrFQhADZrnwrIoRE4SDbJKMKQDCCFmrK%2Fm0ZMViAZxSd9qMf5ZFxa%2FOP5s6jOuvqjVsH8FL%2FthgMGtZCzrv227hNo1AbMEZGHWtIgKjS4KKADYfQ7IDazawUMmzEqDJsFsFl%2BTnbQ1niCzOZau4DZTNm8Eg%2BDl099Mlh7%2BnKoAQ591dgoU0n6AsjcpuyUqVOqoQIbZbqUjTIXVcvNu6TqucmYwj2UNEQFd6x0KTtW%2Fp683iSjx1n69zI5nZhdJnZtGF0X7X64yYTA8KnhEAFISeTYwhBMSiJlv0utUhIDBTwiyjaSJiVRkZREDn2BuSG33thyMDMbfqLLT0mk7Jqpz7Smli5gnFN2qSyHqonshBecg2jrvbMpj0bAIDlSo%2B5HSSTLT0KMyBmwTl5TpEDZT0TOYrvb2HS4fhRH6KGw1sMJcBtSOJ2Nl1k8GyVmq5%2BDnVv91HOdzS%2BxQw0dEhY7NZL15ZtRjcrbmFE7wissuuTIWSczyuP4Dsq6UXoOueypjhm138GwLSweVb5zD4%2F6VampEBB2H6BYWH3fBzQuEGikC%2FkmQE5Yx2kx5C1GyBCAzXgwqK7DPLqCg3E11paVxDjF9uob4xoXHzTShYxxcmEZY7yLtsNdL0zo3RyBRzFgAI1f2QC6e0DTKnF7JjTSeK240S5gQiPS8Sqd6HJrOCBwZjm4Of9aDrN%2FnN%2BcXd7eNCf%2BvPx2qjPRORQGh%2BimrEEc0SkFv30Tva0xBpro8IsaPER6V5jokMbc64OBjLw5dAOH02bjEHGcphT%2F9s3pts4XaE7D3zbEQ6Q59ctypvHL3VOSlXkV8UP3Xrfuhb48kYdD2rY9XA1pd5KWVujbM2lxFpOepI2YIyKNtC5pMj0mxYW%2BK0bFcJcT9Uc1u3TAoNol7TKD6q5QTdn%2BqW9Uk96URnnyjXohw5r0j0Tmye%2BfrVed1JfPHGqBw2dTxiSOz4F8Pmtdx9SoFzKfSd%2Fove35Oj8YDH07KWzql74sm9Ek44cEJ44XlyDNX6%2BSyWp14rR5ZJ1evi5usouPfPyYTyfVFyyZjT9l2eqinl5N49n4chW6VT0U7YHkJc3%2FjX%2B3OP5PGb0jr%2Frp8wv%2BGpc%2FvOIfZsX1%2BPfqiRby8Yn1b1rFp6xONL%2B8%2BunNb39PsrS4rKtyLIsa92pWupgvs1HyzmW17UoKOb4P7XomwnsdlBeZFR%2B2RdFIfTJbBedX8uZPpimneo%2Fv5Z3sYKOhEFYg3ufQRuGW%2FtYXoPrFRoLkayHitdzt11pfIuK1VnKuP34LhbPs5gFE4SFC72u8%2BEGGSG08zYMj0now1AjL3dphk12klnVU7u6J%2FzmEZMMjZ6s8UbhqGVIuulVtcTu9mX%2BNZ6%2BtAfwWvt4H6G0j4JBRwA5u2wpHwHX3tVpmVrQ3Zbdfyt5%2BKeFyZUghESfX%2FSXk4F7rH9%2BocYERHAlRGGjvzUB767VCtPVS3Uno7ur5%2Fr%2FuX87h6K%2FU%2BePvz%2Bf%2B8eyw97v0G97tyS7MSesoivw3rLR7vJGzi9gJQ2gidrd15%2B8pYdxWYucLCRaw1Bv2%2FuKpufaheFzLiEeUeKTePvcZ7fUhuDozBIzgkP%2BRTlgF53rE8G%2F73i1Ycgy5gvBuuDtl9%2FEcFrfYAyOmphag%2FfiNMhT0hU0BqHJiyE0UT7ByHBa%2BHYd9MGmlDMQkTGSZVVznRsFRsRse2XZjnuDu47UQHdx9j1fTQbCtaa9nRDLUIkMc0nHICYEb0nn2URhG9b8wIOQU7SenaHuwGAX9EhJ%2FdWXfcRuQ%2FecNx7qmGvJ8RhkiePacVt6KzZBiAW%2BsR5%2BWBMLmJSHzml0AbV5y6PtbEnO34casVjvYmuP426vPotXa%2B1CSZcFuc3k52BTyYTHIDOx91pf7nXfX9s3HRk8AbZAZEPfuPdUdbr%2BQwJUSurh7H1Nyibuv2XidBQBGYof%2BtiNTz7V4RWZvJz0QMBYtst6Tej62E30%2F2H8mbnekyw8h6bnM64EhuEEAMWaNtseZ7ENWtDUIQD1LmKVps7SsHXK5L%2BTW9v4aRSGrRut6HTgaJQaqnrUnZbfFXtei9KVQB6JCMTGLUallBW%2BxWaWXdTNMtXvNVWPXvGvb4DTvhVuaR3taoturRkicIfp68Su%2F%2BtO7%2FfL4978e%2Fvj9%2Bbf%2FpUn%2Fa0Y8qZSF4N23Ei1Dsrf5f2Stf31jnmfZwT5foBay9xCj7G3cHAKO7D07Ooo2%2Fm19CWwXecUV3XeA4pWA25mzGXQ2XCl%2BzObzfPPpWfz0%2BHU%2BTspn%2FB8%3D)

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
