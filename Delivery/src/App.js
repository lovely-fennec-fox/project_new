import React from 'react';
import logo from './logo.svg';
import Nav from './nav/Nav';
import Signin from './body/Signin';
import { Route, HashRouter } from "react-router-dom";
import './App.css';

function App() {
  return (
    <HashRouter>
      <div className="App">
        <Nav />
        <Route exact path="/signin" component={Signin}></Route>
      </div>
    </HashRouter>
  );
}

export default App;
