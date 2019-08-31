import React, {Component} from 'react';
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
    }

    render(){
        return(
            <div className = "Signin">
                <div className = "Signinbox">
                    <span>환영합니다!</span>
                    <form>
                        ID
                        <input type="text" placeholder="abc123@google.com" onChange={this.active}/>
                        Password
                        <input type="password" placeholder="10자리 이상" onChange={this.active}/>

                        <div className="signinbtn">로그인</div>
                    </form>
                </div>
            </div>
        )
    }
}

export default Signin;