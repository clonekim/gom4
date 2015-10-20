var config = require('./config'),
	express = require('express'),
	env = process.env.NODE_ENV || config.env,
	port = process.env.PORT || config.server.port,
	logger = require('morgan'),
	path = require('path'),
	app = express(),
	router = require('./router'),
	listen = function() {
	
		app.set('view engine', config.server.viewEngine);
		app.set('views', path.join(__dirname, config.server.viewDir));
		app.set('case sensitive routing', true),
		app.set('x-powered-by', false);
		app.use(logger(config.server.logger.format));
		app.use(express.static(path.join(__dirname, config.server.staticDir)));
		router(app);		
		
		app.listen(port, function() {
			console.log('listening on port %d', port);
		});
	};		
	
	

	listen();
