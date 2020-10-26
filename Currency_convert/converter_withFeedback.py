# Real life Currency convertor
# Get the free API here :- www.alphavantage.co
# A basic format for use of API is : Format " https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=JPY&apikey=demo ""


import tkinter as tk
from tkinter import *
import json
import requests
from PIL import ImageTk,Image
from tkinter import filedialog,Text
from tkinter import messagebox
from tkinter.ttk import Combobox
import smtplib  #SIMPLE MAIL TRANSFER PROTOCOL
from tkinter.scrolledtext import ScrolledText



CURRENCIES=["INR", "USD", "CAD", "CNY", "DKK", "EUR","JPY"]  # Add the currencies 

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
        s.sendmail(r,e,Body)
        messagebox.showinfo("Success",'Your Message has been send successfully')
        

def help_me():
    root1=tk.Tk()
    root1.title("Help")
    root1.configure(background = 'light green')
    root1.geometry("600x175") 
    text="This is a real life currency converter which uses API to get the recent values.\nSelect the From currency and To Currency.\nEnter the value in Integer and press Convert button"  
    text=text+"\nClick on exit button to exit the window\nOn the top menubar click on fullforms for any help required :-)"
    lab1=Label(root1,text=text,font= ('verdana',10,'bold'),bg='white',fg='black')
    lab1.place(x=10,y=30)
    root1.mainloop()

def fullform():
    root1=tk.Tk()
    root1.title("Fullforms")
    root1.configure(background = 'white')
    root1.geometry("400x400") 
    text= "Fullforms :"
    lab1=Label(root1,text=text,font= ('verdana',13,'bold'),bg='white',fg='blue')

    s1=Label(root1,text="INR :Indian Rupees",font= ('verdana',11,'bold'),bg='white',fg='black',padx=5,pady=5)
    s2=Label(root1,text="USD :United states Dollar",font= ('verdana',11,'bold'),bg='white',fg='black',padx=5,pady=5)
    s3=Label(root1,text="CAD :Canadian Dollar",font= ('verdana',11,'bold'),bg='white',fg='black',padx=5,pady=5)
    s4=Label(root1,text="CNY :Chinese Yuan Renminbi ",font= ('verdana',11,'bold'),bg='white',fg='black',padx=5,pady=5)
    s5=Label(root1,text="DKK :Danish krone (Denmark,greenland)",font= ('verdana',11,'bold'),bg='white',fg='black',padx=5,pady=5)
    s6=Label(root1,text="EUR :Euro",font= ('verdana',11,'bold'),bg='white',fg='black',padx=5,pady=5)
    s7=Label(root1,text="JPY : Japanese Yen",font= ('verdana',11,'bold'),bg='white',fg='black',padx=5,pady=5)
    lab1.grid(row=1,column=0)
    s1.grid(row = 3, column = 0)  
    s2.grid(row = 5, column = 0) 
    s3.grid(row = 7, column = 0) 
    s4.grid(row = 9, column = 0) 
    s5.grid(row = 11, column = 0)  
    s6.grid(row = 13, column = 0) 
    s7.grid(row = 15, column = 0) 
    root1.mainloop()

def about_me():
    root1=tk.Tk()
    root1.title("About Author")
    root1.configure(background = 'light green')
    root1.geometry("600x175") 
    text="This project uses GUI by tkinter and give real life currency convertor using APIs.\nThe menubar wasn't a required feature in this project but \njust an example to illustrate the use of menubars\n"  
    lab1=Label(root1,text=text,font= ('verdana',10,'bold'),bg='white',fg='black')
    lab1.place(x=10,y=30)
    author2=Label(root1,text="Made by Aishwarya Jamdar ",font= ('verdana',12,'bold'),bg='light green',fg='black')
    author2.place(x=200,y=130)
    root1.mainloop()

def mail_me():
    global s
    global receipent,e
    global subject
    global message
    e="diamondsshine532@gmail.com"
    p="krutika%3012"
    try:

        s=smtplib.SMTP('smtp.gmail.com', 587)
        s.ehlo()
        s.starttls()
        s.login(e,p)
            # The mail sender window design
        root=tk.Tk()
        root.geometry('400x400')
        root.title("Send Email")
        header1=Label(root,bg="dark orange",width=300,height=2)
        header1.place(x=0,y=0)
        h2=Label(root,text="Send Email",fg="black",bg="dark orange",font=('verdana',13,'bold'))
        h2.place(x=150,y=5)
        
    
        r=Label(root,text="Your email Address :",font=('verdana',10,'bold'))
        r.place(x=30,y=90)
        receipent=Entry(root,width=30,relief=RIDGE,borderwidth=3)
        receipent.place(x=30,y=120)

        sub=Label(root,text="Subject :",font=('verdana',10,'bold'))
        sub.place(x=30,y=160)
        subject=Entry(root,width=30,relief=RIDGE,borderwidth=3)
        subject.place(x=30,y=180)

        m=Label(root,text="Message :",font=('verdana',10,'bold'))
        m.place(x=30,y=200)
        message=ScrolledText(root,width=40,height=5,relief=RIDGE,borderwidth=3)
        message.place(x=30,y=230)

        send_=Button(root,text="Send",padx=30,cursor="hand2",relief=RIDGE,borderwidth=1,bg="dark orange",font=('verdana',10,'bold'),command=send)
        send_.place(x=50,y=350)
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


def convert_currency():

    #Format " https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=USD&to_currency=JPY&apikey=demo ""

    API ="JIXXXXXXXXXX"
    BASE_URL=r"https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE"
    c1=f_currency.get()
    c2=to_currency.get()
    main_url = BASE_URL + "&from_currency=" + c1 + "&to_currency=" + c2 + "&apikey=" + API
    
    req = requests.get(main_url)
    result = req.json()  # Recieve the JSON file 
    Exchange_Rate = float(result["Realtime Currency Exchange Rate"] ['5. Exchange Rate']) 
    print(Exchange_Rate)

    Last_refreshed =result["Realtime Currency Exchange Rate"] ['6. Last Refreshed']
    #print(result)
    #print(main_url)
    amount=value.get()
    new_amount = round(float(amount) * Exchange_Rate, 3) 
    CONVERTED.insert(0, str(new_amount))
    final_str="1 "+c1+" ="+str(new_amount)+" "+c2 +" \t   - Date :"+str(Last_refreshed)
    label3.configure(text=final_str)
    print("From currency :{0}\nTo currency :{1}\nConverted value :{2}".format(c1,c2,new_amount))

# The main GUI 
root=tk.Tk()
root.title("Currency Convertor")

# Menubars on top
menubar=Menu(root)
filemenu=Menu(menubar,tearoff=0)
filemenu.add_command(label="Help" ,command=help_me)
filemenu.add_command(label="Fullforms",command=fullform)
filemenu.add_command(label="Feedback",command=mail_me)
filemenu.add_command(label="Report Error",command=mail_me)
menubar.add_cascade(label="Help",menu=filemenu,font=('Arial ',11,'bold'))

author=Menu(menubar,tearoff=0)
author.add_command(label="Author",command=about_me)
menubar.add_cascade(label="Author",menu=author,font=('Arial',11,'bold'))
root.config(menu=menubar)
# Ends here

canvas=tk.Canvas(root,height=650,width=550,bg="white")
canvas.pack()
title=Label(canvas,text="Real time Currency Convertor" ,bd=1,fg="brown4",font=('Lato Heavy',27,'bold'),bg="white")
title.place(x=30,y=30)

img = ImageTk.PhotoImage(Image.open('/home/krutika/Python_stuff/Currency_convert/convertor_logo.png'))  # Change the directory name
tile = Label(canvas, image = img)
tile.image = img
tile.place(x=150,y=90,height=200,width=200)

get_value=Label(canvas,text="Value :",font=('verdana',13,'bold'),bg='white',fg='black')
get_value.place(x=30,y=300)
data_value = IntVar()
value=Entry(canvas,width=30,textvariable=data_value,font=('verdana',11,'bold'))
value.place(x=100,y=300)

label1=Label(canvas,text="From Currency :",font= ('verdana',13,'bold'),bg='white',fg='black')
label1.place(x=30,y=340)
from_curr=StringVar()
f_currency=Combobox(canvas,width=30,textvariable=from_curr,state='readonly') # Combobox is used 
f_currency['values']=[i for i in CURRENCIES]
f_currency.current(0)
f_currency.place(x=200,y=340)

label2=Label(canvas,text="To Currency :",font= ('verdana',13,'bold'),bg='white',fg='black')
label2.place(x=30,y=390)
to_curr=StringVar()
to_currency=Combobox(canvas,width=30,textvariable=to_curr,state='readonly')
to_currency['values']=[i for i in CURRENCIES]
to_currency.current(1)
to_currency.place(x=180,y=390)

l_convert=Label(canvas,text="Currency Converted :",font= ('verdana',13,'bold'),bg='white',fg='brown4')
l_convert.place(x=30,y=430)
CONVERTED =Entry(canvas,width=30,font=('verdana',11,'bold'))
CONVERTED.place(x=30,y=460)

label3 =Label(canvas,text="",font= ('verdana',13,'bold'),bg='white',fg='black')
label3.place(x=30 ,y=510)

imgbt1 = PhotoImage(file='1.png')
imgbt2 = PhotoImage(file='2.png')
imgbt1 = imgbt1.subsample(2,2)
imgbt2 = imgbt2.subsample(2,2)

bttn1 = Button(canvas,text='Convert',bd=2,bg='white', activebackground ='plum3',width=130,font= ('verdana',12,'bold'),
               image =imgbt1,compound=RIGHT,command=convert_currency)
bttn1.place(x=40,y=560)
bttn2 = Button(canvas,text='Exit',bd=2,bg='white', activebackground ='plum3',width=130,height=50,font= ('verdana',12,'bold'),
               image =imgbt2,compound=RIGHT,command=root.destroy)
bttn2.place(x=320,y=560)



root.mainloop()