import _ from 'lodash';

function csrf() {
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

export default function request(url, options) {
    const opts = _.merge({headers: csrfToHeaders(), method: 'POST'}, options);
    return fetch(url, opts)
        .catch(e => {
            console.error(e);
        })
}