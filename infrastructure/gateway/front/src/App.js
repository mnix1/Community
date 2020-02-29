import React from 'react';
import './App.css';

export function csrf() {
    try {
        const token = document.getElementsByName('_csrf')[0].getAttribute('content');
        const header = document.getElementsByName('_csrf_header')[0].getAttribute('content');
        return {header, token};
    } catch (e) {
        return {};
    }
}

function csrfToHeaders() {
    const securityCsrf = csrf();
    if (!securityCsrf.token) {
        return {};
    }
    return {[securityCsrf.header]: securityCsrf.token};
}

function csrfRequest(url, data, method = 'POST') {
    const opts = {headers: csrfToHeaders(), method};
    if (data) {
        opts.body = JSON.stringify(data);
        opts.headers = {
            ...opts.headers, ...{
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            }
        };
    }
    return fetch(url, opts)
        .then(res => res.json())
        .catch(e => {
            console.error(e);
        })
}

export default function App() {
    const onClick = e => csrfRequest('/logout');
    return (
        <div className="App">
            <header className="App-header">
                WELCOME
                <button onClick={onClick}>Logout</button>
            </header>
        </div>
    );
}
