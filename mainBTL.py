import pyodbc
import flask
from configBTL import conn_str
conn = pyodbc.connect(conn_str)
app = flask.Flask(__name__)
@app.route('/getUser', methods = ['GET'])
def getName():
            # user = flask.request.json.get("user")
            # passWord = flask.request.json.get("passWord")
            cursor = conn.cursor()
            # sql = "exec getUser @user = ?, @pass = ?"
            sql = "Select * from Admin"
            #data = (user, passWord)
            cursor.execute(sql) #thực thi
            results = [] # chứa kết quả trả về
            keys = []   
            for i in cursor.description:
                keys.append(i[0]) #lấy key
            for i in cursor.fetchall():
                results.append(dict(zip(keys,i)))
            resp = flask.jsonify(results)
            resp.status_code = 200  
            return resp
@app.route('/getTKSV', methods = ['GET'])
def getTK():
            # user = flask.request.json.get("user")
            # passWord = flask.request.json.get("passWord")
            cursor = conn.cursor()
            # sql = "exec getUser @user = ?, @pass = ?"
            sql = "Select * from TKSinhVien"
            #data = (user, passWord)
            cursor.execute(sql) #thực thi
            results = [] # chứa kết quả trả về
            keys = []   
            for i in cursor.description:
                keys.append(i[0]) #lấy key
            for i in cursor.fetchall():
                results.append(dict(zip(keys,i)))
            resp = flask.jsonify(results)
            resp.status_code = 200  
            return resp
@app.route('/getKhoa', methods = ['GET'])
def getKhoa():
            # user = flask.request.json.get("user")
            # passWord = flask.request.json.get("passWord")
            cursor = conn.cursor()
            # sql = "exec getUser @user = ?, @pass = ?"
            sql = "Select MaKhoa from Khoa"
            #data = (user, passWord)
            cursor.execute(sql) #thực thi
            results = [] # chứa kết quả trả về
            keys = []   
            for i in cursor.description:
                keys.append(i[0]) #lấy key
            for i in cursor.fetchall():
                results.append(dict(zip(keys,i)))
            resp = flask.jsonify(results)
            resp.status_code = 200  
            return resp
@app.route('/getNienKhoa', methods = ['GET'])
def getNiemKhoa():
            # user = flask.request.json.get("user")
            # passWord = flask.request.json.get("passWord")
            cursor = conn.cursor()
            # sql = "exec getUser @user = ?, @pass = ?"
            sql = "Select Khoa from NienKhoa"
            #data = (user, passWord)
            cursor.execute(sql) #thực thi
            results = [] # chứa kết quả trả về
            keys = []   
            for i in cursor.description:
                keys.append(i[0]) #lấy key
            for i in cursor.fetchall():
                results.append(dict(zip(keys,i)))
            resp = flask.jsonify(results)
            resp.status_code = 200  
            return resp
@app.route('/sv/insert', methods = ['POST'])
def insertSV():
        try:
            ID = flask.request.json.get("ID")
            HoTen = flask.request.json.get("HoTen")
            GioiTinh = flask.request.json.get("GioiTinh")
            NgaySinh = flask.request.json.get("NgaySinh")
            SDT = flask.request.json.get("SDT")
            DiaChi = flask.request.json.get("DiaChi")
            MaKhoa = flask.request.json.get("MaKhoa")
            Khoa = flask.request.json.get("Khoa")
            Email = flask.request.json.get("Email")
            cursor = conn.cursor()
            sql = "Insert into SinhVien (ID, HoTen, GioiTinh, NgaySinh, SDT, DiaChi, MaKhoa, Khoa, Email) values (?,?,?,?,?,?,?,?,?)"
            data = (ID, HoTen, GioiTinh, NgaySinh, SDT, DiaChi, MaKhoa, Khoa, Email)
            cursor.execute(sql, data)
            cursor.commit()
            res = flask.jsonify({"mess":"Thanh cong"})
            res.status_code = 200
            return res
        except Exception as e:
            res = flask.jsonify({"mess":e})
            res.status_code = 200
            return res
#tk sinh vien
@app.route('/tksv/insert', methods = ['POST'])
def insertTKSV():
        try:
            ID = flask.request.json.get("ID")
            PassWordSV = flask.request.json.get("PassWordSV")
            cursor = conn.cursor()
            sql = "INSERT INTO TKSinhVien (ID, PassWordSV) VALUES (?,?)"
            data = (ID, PassWordSV)
            cursor.execute(sql, data)
            cursor.commit()
            res = flask.jsonify({"mess":"Thanh cong"})
            res.status_code = 200
            return res
        except Exception as e:
            res = flask.jsonify({"mess":e})
            res.status_code = 200
            return res
@app.route('/hp/insert', methods = ['POST'])
def insertHP():
        try:
            MaHP = flask.request.json.get("MaHP")
            TenHP = flask.request.json.get("TenHP")
            SoTC = flask.request.json.get("SoTC")
            SL = flask.request.json.get("SL")
            cursor = conn.cursor()
            sql = "Insert into HocPhan (MaHP, TenHP, SoTC, SL) values (?,?,?,?)"
            data = (MaHP, TenHP, SoTC, SL)
            cursor.execute(sql, data)
            cursor.commit()
            res = flask.jsonify({"mess":"Thanh cong"})
            res.status_code = 200
            return res
        except Exception as e:
            res = flask.jsonify({"mess":e})
            res.status_code = 200
            return res
@app.route('/cthp/insert', methods = ['POST'])
def insertCTHP():
        try:
            MaHP = flask.request.json.get("MaHP")
            MaCTHP = flask.request.json.get("MaCTHP")
            Start = flask.request.json.get("Start")
            End = flask.request.json.get("End")
            Phong = flask.request.json.get("Phong")
            Ca = flask.request.json.get("Ca")
            Thu = flask.request.json.get("Thu")
            cursor = conn.cursor()
            sql = "Insert into ChiTietTC (MaHP, MaCTHP, Start, [End], Phong, Ca, Thu) values (?,?,?,?,?,?,?)"
            data = (MaHP, MaCTHP, Start, End,Phong,Ca,Thu)
            cursor.execute(sql, data)
            cursor.commit()
            res = flask.jsonify({"mess":"Thanh cong"})
            res.status_code = 200
            return res
        except Exception as e:
            res = flask.jsonify({"mess":e})
            res.status_code = 200
            return res

@app.route('/getInfo/', methods = ['GET'])
def getInfo():
        try:
            username = flask.request.json.get("UserName")
            password = flask.request.json.get("PassWord")
            cursor = conn.cursor()
            sql = "exec getInfo @username=?, @password =?"
            data=(username,password)
            cursor.execute(sql,data)
            results = []  #chua ket qua tra ve
            keys = []
            for i in cursor.description:
                keys.append(i[0])  #lay key
            for i in cursor.fetchall():
                results.append(dict(zip(keys,i)))
            resp = flask.jsonify(results)
            resp.status_code = 200
            return resp
        except Exception as e:
            res = flask.jsonify({"mess"  : e})
            res.status_code = 200
            return res
@app.route('/Admin/changePass',methods=['POST'])
def changePass():
        try:
            newpass = flask.request.json.get("newPass")
            username = flask.request.json.get("UserName")
            password = flask.request.json.get("PassWord")
            cursor = conn.cursor()
            sql = "exec changePassword @newpass = ?, @username = ?, @password = ?"
            data=(newpass,username,password)
            cursor.execute(sql,data)
            cursor.commit()
            res = flask.jsonify({"mess" : "thanh cong"})
            res.status_code = 200
            return res
        except Exception as e:
            res = flask.jsonify({"mess"  : e})
            res.status_code = 200
            return res
@app.route('/GetAll',methods=['GET'])
def getAllCourse():
        cursor = conn.cursor()
        sql = "exec getListCourse"
        cursor.execute(sql) #thuc thi
        results = []  #chua ket qua tra ve
        keys = []
        for i in cursor.description:
            keys.append(i[0])  #lay key
        for i in cursor.fetchall():
            results.append(dict(zip(keys,i)))
        resp = flask.jsonify(results)
        resp.status_code = 200
        return resp
@app.route('/getDetailCourse/<id>',methods=['GET'])
def getDetailCourse(id=1):
        cursor = conn.cursor()
        sql = "exec getDetailCourse @mahp = ?"
        data = (id)
        cursor.execute(sql, data) #thuc thi
        results = []  #chua ket qua tra ve
        keys = []
        for i in cursor.description:
            keys.append(i[0])  #lay key
        for i in cursor.fetchall():
            results.append( dict(zip(keys,i)))
        res = flask.jsonify(results)
        res.status_code = 200
        return res
@app.route('/Insert/KQDK',methods=['POST'])
def insertKQDK():
        try:
            id =flask.request.json.get("ID")
            mahp = flask.request.json.get("MaHP")
            cursor = conn.cursor()
            sql = "declare @kqdk_type KQDK_Type insert into @kqdk_type(ID, MaHP, [isDeleted]) values (?, ?,0) exec insertKQDK @kqdk = @kqdk_type"
            data=(id,mahp)
            cursor.execute(sql,data)
            cursor.commit()
            res = flask.jsonify({"mess" : "thanh cong"})
            res.status_code = 200
            return res
        except Exception as e:
            res = flask.jsonify({"mess"  : e})
            res.status_code = 200
            return res
        
@app.route('/Update/KQDK',methods=['POST'])
def updateKQDK():
        try:
            mahp = flask.request.json.get("MaHP")
            cursor = conn.cursor()
            sql = "exec updateKQDK @mahp = ?"
            data=(mahp)
            cursor.execute(sql,data)
            cursor.commit()
            res = flask.jsonify({"mess" : "thanh cong"})
            res.status_code = 200
            return res
        except Exception as e:
            res = flask.jsonify({"mess"  : e})
            res.status_code = 200
            return res
@app.route('/GetKQDK/<id>',methods=['GET'])
def get_KQDK_By_ID(id=1):
        cursor = conn.cursor()
        sql = "exec get_KQDK_by_ID @id = ?"
        data = (id)
        cursor.execute(sql, data) #thuc thi
        results = []  #chua ket qua tra ve
        keys = []
        for i in cursor.description:
            keys.append(i[0])  #lay key
        for i in cursor.fetchall():
            results.append( dict(zip(keys,i)))
        res = flask.jsonify(results)
        res.status_code = 200
        return res

@app.route('/GetLichHoc/<id>',methods=['GET'])
def get_LichHoc(id=1):
        cursor = conn.cursor()
        sql = "exec get_LichHoc @id = ?"
        data = (id)
        cursor.execute(sql, data) #thuc thi
        results = []  #chua ket qua tra ve
        keys = []
        for i in cursor.description:
            keys.append(i[0])  #lay key
        for i in cursor.fetchall():
            results.append( dict(zip(keys,i)))
        res = flask.jsonify(results)
        res.status_code = 200
        return res

@app.route('/GetLichThi/<id>',methods=['GET'])
def getLichThi(id=1):
        cursor = conn.cursor()
        sql = "exec getLichThi @id = ? "
        data = (id)
        cursor.execute(sql, data) #thuc thi
        results = []  #chua ket qua tra ve
        keys = []
        for i in cursor.description:
            keys.append(i[0])  #lay key
        for i in cursor.fetchall():
            results.append(dict(zip(keys,i)))
        resp = flask.jsonify(results)
        resp.status_code = 200
        return resp

@app.route('/SinhVien/changeProfile',methods=['POST'])
def changeProfile():
        try:
            id = flask.request.json.get("ID")
            hoten = flask.request.json.get("HoTen")
            ngaysinh = flask.request.json.get("NgaySinh")
            sdt = flask.request.json.get("SDT")
            mail = flask.request.json.get("Email")
            diachi = flask.request.json.get("DiaChi")
            cursor = conn.cursor()
            sql = "DECLARE @inp ChangeProfile; INSERT INTO @inp (ID, HoTen, NgaySinh, SDT, DiaChi, Email) VALUES (?, ?, ?, ?, ?, ?); EXEC changeProfile @input = @inp"
            data=(id,hoten,ngaysinh,sdt, diachi,mail)
            cursor.execute(sql,data)
            cursor.commit()
            res = flask.jsonify({"mess" : "thanh cong"})
            res.status_code = 200
            return res
        except Exception as e:
            res = flask.jsonify({"mess"  : e})
            res.status_code = 200
            return res
        
@app.route('/getInfoByID/<id>',methods=['GET'])
def getInfoByID(id=1):
        cursor = conn.cursor()
        sql = "exec getInfoByID ?"
        data = (id)
        cursor.execute(sql, data) #thuc thi
        results = {}  #chua ket qua tra ve
        keys = []
        for i in cursor.description:
            keys.append(i[0])  #lay key
        for i in cursor.fetchall():
            results = dict(zip(keys,i))
        res = flask.jsonify(results)
        res.status_code = 200
        return res

if __name__ == "__main__":
        app.run(host="192.168.1.143",port=3333)