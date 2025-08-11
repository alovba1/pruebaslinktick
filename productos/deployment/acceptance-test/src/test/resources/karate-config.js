function fn() {
    var env = karate.env;
    karate.log('karate.env system property was:', env);
    if (!env) {
        env = 'dev';
    }
    var config = {
        urlBase: 'http://localhost:9091',
        anotherUrlBase: 'https://dev-host.com/v1/'
    };
    if (env == 'dev') {
        config.urlBase = 'http://localhost:9091';
    } else if (env == 'qa') {
        config.urlBase = 'http://localhost:9091';
    } else if (env == 'pdn') {
        config.urlBase = 'http://pdn-localhost:8443';
    }
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    karate.configure('ssl', true);
    return config;
}