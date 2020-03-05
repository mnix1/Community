import React from 'react';
import './App.css';
import request from "./fetchHelper";


export default function App() {
    const onClick = e => request('/logout');
    return (
        <div className="App">
            <header className="App-header">
                WELCOME
                <button onClick={onClick}>Logout</button>
            </header>
        </div>
    );
}
