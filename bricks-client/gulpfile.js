var gulp = require('gulp');
var browserify = require('browserify');
var babelify = require('babelify');
var source = require('vinyl-source-stream');

gulp.task('build', function() {
	return browserify('./source/app.js')
		.transform(babelify)
		.bundle()
		.pipe(source('app.js'))
		.pipe(gulp.dest('../bricks03/resources/public/js/'));
});

gulp.task('watch', function() {
  gulp.watch('./source/**/*.js', ['build']);
});

