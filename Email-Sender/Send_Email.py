# Please Allow less secure access in your mail and you can be able send mails

#Importing all the required libraries
from tkinter import *
import tkinter as tk
from tkinter import messagebox
from PIL import ImageTk,Image
import smtplib  #SIMPLE MAIL TRANSFER PROTOCOL
from tkinter.scrolledtext import ScrolledText


def send():
    
    r=receipent.get()
    sub=subject.get()
    main_message=message.get('1.0','end-1c')
    Body="""From:%s
    To: %s
    Subject:%s 

    %s
    """ %(e,r,sub,main_message )
    print(Body)
    print("e :{0} ,r:{1}".format(e,r))
   
    if '@gmail.com' not in r or r == "":
        messagebox.showerror('Receipent Mail error','Please give a valid email')

    elif main_message == "":
        messagebox.showerror('Sending mail error','Message is empty')

    else:
        s.sendmail(e,r,Body)
        messagebox.showinfo("Success",'Your Message has been send successfully')
        


def logout():
    global s
    s.quit()
    root.destroy()

def login():
    global e
    # Get the inputs given by user
    e=email.get()
    p=password.get() 

    #Check if proper email is given
    if '@gmail.com' not in e or e == "":
        messagebox.showerror('Login error',"Please give a valid Email")
    elif p=="":
        messagebox.showerror('Login error',"Password entry is empty")

    else:
        try:
            global s
            global receipent
            global subject
            global message

            s=smtplib.SMTP('smtp.gmail.com', 587)
            s.ehlo()
            s.starttls()
            s.login(e,p)
            messagebox.showinfo("Loin Successfull","Logged into gmail Account")

            # The mail sender window design
            root=tk.Tk()
            root.geometry('500x400')
            header1=Label(root,bg="dark orange",width=300,height=2)
            header1.place(x=0,y=0)
            h2=Label(root,text="Email Sender",fg="black",bg="dark orange",font=('verdana',13,'bold'))
            h2.place(x=175,y=5)
            logout_=Button(root,text="Logout",padx=20,bg="dark orange",relief=RIDGE,borderwidth=3,font=('verdana',10,'bold'),cursor='hand2',command=logout)
            logout_.place(x=200,y=40)
    
            r=Label(root,text="Recepient email Address :",font=('verdana',10,'bold'))
            r.place(x=130,y=130)
            receipent=Entry(root,width=30,relief=RIDGE,borderwidth=3)
            receipent.place(x=130,y=150)

            sub=Label(root,text="Subject :",font=('verdana',10,'bold'))
            sub.place(x=130,y=190)
            subject=Entry(root,width=30,relief=RIDGE,borderwidth=3)
            subject.place(x=130,y=210)

            m=Label(root,text="Message :",font=('verdana',10,'bold'))
            m.place(x=130,y=250)
            message=ScrolledText(root,width=40,height=5,relief=RIDGE,borderwidth=3)
            message.place(x=130,y=270)

            send_=Button(root,text="Send",padx=30,cursor="hand2",relief=RIDGE,borderwidth=1,bg="dark orange",font=('verdana',10,'bold'),command=send)
            send_.place(x=350,y=360)
            root.mainloop()

        except Exception as e:
            print("Error occured.Here are the details :")
            print(e)
            #messagebox.showerror('Failed to login','Your email or password is wrong or click on help for more details')
            ask_help=messagebox.askquestion('Help','Do u need help. Please select Yes to get help',icon = 'help')
            if ask_help=='Yes':
                messagebox.showinfo('Help',' Click and unable for your account : https://www.google.com/settings/security/lesssecureapps')
            else:
                pass


# Login page design
root=tk.Tk()
root.title('Email Sender')
canvas = tk.Canvas(root,height =400,width = 600,bg = 'white')
canvas.pack()
header=Label(canvas,bg='dark orange',width=600,height=3)
header.place(x=0,y=0)
title=Label(canvas,text="Email Sender",fg="black",bg="dark orange",font=('verdana',18,'bold'))
title.place(x=200,y=8)
icon=ImageTk.PhotoImage(Image.open('/home/krutika/Picture/logo.png'))
logo=Label(canvas,image=icon,borderwidth=0)
logo.place(x=200,y=52)

e=Label(canvas,text="Email Address :",font=('verdana',11,'bold'),bg="white")
e.place(x=65,y=233)
email=Entry(canvas,width=30,relief=RIDGE,borderwidth=3)
email.place(x=200,y=230)

p=Label(canvas,text="Password :",font=('verdana',11,'bold'),bg="white")
p.place(x=100,y=280)
password=Entry(canvas,width=30,relief=RIDGE,borderwidth=3)
password.place(x=200,y=280)

#As soon as login is successfull,U can write the mail
login=Button(canvas,text="Login",padx=30,bg="orange",cursor="hand2",relief=RIDGE,borderwidth=1,font=('verdana',11,'bold'),command=login)
login.place(x=240,y=340)

root.mainloop()
