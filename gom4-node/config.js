module.exports = {
	
	env: 'development',	
	
	server: {
		port: 80,
		staticDir: 'public',
		viewDir: 'views',
		viewCache: false,
		viewEngine: 'jade',
		trustProxy: true,
		catchException: false,
		logger: {
			format: 'dev'
		}
	},
	
}
