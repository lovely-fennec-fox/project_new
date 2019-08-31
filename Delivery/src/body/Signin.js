import React, {Component} from 'react';
import axios from 'axios';
import './Signin.css';


class Signin extends Component {
    constructor(props){
        super(props);
        this.active = (e)=>{
            if(e.target.value) e.target.classList.add("inputactive");
            else e.target.classList.remove("inputactive");
            console.dir(e.target);
        }
        this.signin = (e)=>{

        }
        this.loginreq = (e) =>{
            e.preventDefault();
            console.dir(e.target);
            axios({
                url: 'http://localhost:8080/login',
                method: 'post',
                data: {
                    email: e.target[0].value,
                    password: e.target[1].value
                }
            })
                .then(res => {
                    console.log(res);
                })
                .catch(err => {
                    console.log(err);
                })
        }
    }

    render(){
        return(
            <div className = "Signin">
                <div className = "Signinbox">
                    <span>환영합니다!</span>
                    <form onSubmit={this.loginreq}>
                        ID
                        <input type="text" placeholder="abc123@google.com" onChange={this.active} name="email"/>
                        Password
                        <input type="password" placeholder="10자리 이상" onChange={this.active} name="password"/>

                        <input type="submit" className="signinbtn" value="로그인"></input>
                    </form>
                </div>
            </div>
        )
    }
}

export default Signin;