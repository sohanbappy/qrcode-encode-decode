# qrcode-encode-decode
--Generate QR code in a simple way (Here used demo DTO using name,phone,mail) <br />
--Read info from QR code images <br />

**API Endpoint:** <br />
-GET > http://localhost:9090/qr/read-qr (param- fileName [string] ) <br />
-POST > http://localhost:9090/qr/generate-qr <br />
BODY: <br />
```
{
	"name" : "bappy",
	"phone" : "01766334885",
	"mail" : "bappy@gmail.com"
}
```
**N.B:** <br />
-static filePath is used. <br />
-helper files added in res folder. <br />

