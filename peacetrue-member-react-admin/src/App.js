// in src/App.js
import React from 'react';
import {Admin, fetchUtils} from 'react-admin';
import polyglotI18nProvider from 'ra-i18n-polyglot';
import chineseMessages from 'ra-language-chinese';
import {springDataProvider} from 'ra-data-spring-rest';
import AuthProvider from "./authProvider";
import {defaultHttpClientJoiner, httpClientProxies} from 'peacetrue-httpclient'
import UserResource from './modules/members';
import AttachmentResource from './modules/attachments';

const apiProxy = httpClient => {
    return (url, options) => {
        if (!url.startsWith("http")) url = 'http://localhost:8607' + url;
        return httpClient(url, options);
    };
};

const resultConverter = httpClient => {
    return (url, options) => {
        return httpClient(url, options)
            .then(response => response.json);
    };
};

export const debugHttpClient = (httpClient) => {
    return (url, options = {}) => {
        console.info("url:", url);
        console.info("options:", options);
        return httpClient(url, options);
    };
};

const i18nProvider = polyglotI18nProvider(() => chineseMessages, 'cn');
let httpClient = defaultHttpClientJoiner(fetchUtils.fetchJson, apiProxy, httpClientProxies.cors, httpClientProxies.springRest, debugHttpClient);

const dataProvider = springDataProvider('http://localhost:8607', httpClient);
const authProvider = AuthProvider('http://localhost:8607', defaultHttpClientJoiner(httpClient, resultConverter));
const App = () => (
    <Admin dataProvider={dataProvider}
        // i18nProvider={i18nProvider}
           authProvider={authProvider}>
        {UserResource}
        {AttachmentResource}
    </Admin>
);

export default App;
