import React, { Component } from 'react';
import { NavLink } from "react-router-dom";
import './Nav.css';

class Nav extends Component {
    constructor(props) {
        super(props);
        this.state = {
            menuclick: false
        }
    }

    render() {
        return (
                <div className="Navbar">
                    <div className="Navlogo">
                        <NavLink to="/"><img src="logo.png" width="130px" height="40.44px" /></NavLink>
                    </div>
                    <div className="Navmenu">
                    <NavLink to="/"><div className="Menubtn">메뉴&nbsp;&nbsp;<i className="fas fa-chevron-right"></i></div></NavLink>
                    <NavLink to="/"><div className="Menubtn">이벤트&nbsp;&nbsp;<i className="fas fa-chevron-right"></i></div></NavLink>
                    <NavLink to="/signup"><div className="Signup">회원가입</div></NavLink>{/* 핑크 상자안에 넣어놓음 */}
                    <NavLink to="/signin"><div className="Login">로그인</div></NavLink>
                    </div>
                    <div className="Navsmallmenu">
                        <i className="fas fa-bars"></i>
                    </div>
                </div>
        )
    }
}

export default Nav;