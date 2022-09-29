# qrcode-encode-decode
*--Generate QR code in a simple way (Here used demo DTO using name,phone,mail)*
*--Read info from QR code images

**API Endpoint:**
#-GET > http://localhost:9090/qr/read-qr (param- fileName [string] )
#-POST > http://localhost:9090/qr/generate-qr 
#BODY:
```
{
	"name" : "bappy",
	"phone" : "01766334885",
	"mail" : "bappy@gmail.com"
}
```
**N.B:**
-static filePath is used.
-helper files added in res folder.
