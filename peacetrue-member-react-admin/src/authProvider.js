let AuthProvider = (url, httpClient) => {
    return {
        login: params => {
            return httpClient(`${url}/login`, {method: 'post', body: params})
                .then(token => {
                    localStorage.setItem('token', token.name);
                    token.authorities && localStorage.setItem('permissions', JSON.stringify(token.authorities));
                });
        },
        logout: params => {
            localStorage.removeItem('token');
            localStorage.removeItem('permissions');
            httpClient(`${url}/logout`, {method: 'post', body: params});
            return Promise.resolve();
        },
        checkAuth: params => {
            return localStorage.getItem("token")
                ? Promise.resolve()
                : Promise.reject();
        },
        checkError: error => {
            console.error("error:", JSON.stringify(error));
            if (error.status === 401) return Promise.reject("unauthorized");
            return Promise.resolve();
        },
        getPermissions: params => {
            const role = localStorage.getItem('permissions');
            return role ? Promise.resolve(JSON.parse(role)) : Promise.reject();
        },
    };
};

export default AuthProvider;
