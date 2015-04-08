# Team 19 - Weather App 

Made for the second-yera Introduction to Software Engineering course in the Department of Computer Science at Western University in London, Ontario, Canada

## Synopsis

This is the best weatherapp you will ever use. 

## Installation and Usage

_MediaElementPlayer: HTML5 `<video>` and `<audio>` player_

A complete HTML/CSS audio/video player built on top `MediaElement.js` and `jQuery`. Many great HTML5 players have a completely separate Flash UI in fallback mode, but MediaElementPlayer.js uses the same HTML/CSS for all players.

## Change Log

Changes available at [changelog.md]

### 1. Add Script and Stylesheet
```html
<script src="jquery.js"></script>
<script src="mediaelement-and-player.min.js"></script>
<link rel="stylesheet" href="mediaelementplayer.css" />
```
### 2. Add `<video>` or `<audio>` tags
If your users have JavaScript and/or Flash, the easiest route for all browsers and mobile devices is to use a single MP4 or MP3 file.

```html	
<video src="myvideo.mp4" width="320" height="240"></video>
```
```html	
<audio src="myaudio.mp3"></audio>
```

#### Optional: multiple codecs
This includes multiple codecs for various browsers (H.264 for IE9+, Safari, and Chrome, WebM for Firefox 4 and Opera, Ogg for Firefox 3).

```html
<video width="320" height="240" poster="poster.jpg" controls="controls" preload="none">
	<source type="video/mp4" src="myvideo.mp4" />
	<source type="video/webm" src="myvideo.webm" />
	<source type="video/ogg" src="myvideo.ogv" />
</video>
```

#### Optional: Browsers with JavaScript disabled
In very rare cases, you might have an non-HTML5 browser with Flash turned on and JavaScript turned off. In that specific case, you can also include the Flash `<object>` code.
```html
<video width="320" height="240" poster="poster.jpg" controls="controls" preload="none">
	<source type="video/mp4" src="myvideo.mp4" />
	<source type="video/webm" src="myvideo.webm" />
	<source type="video/ogg" src="myvideo.ogv" />
	<object width="320" height="240" type="application/x-shockwave-flash" data="flashmediaelement.swf">
		<param name="movie" value="flashmediaelement.swf" /> 
		<param name="flashvars" value="controls=true&amp;poster=myvideo.jpg&amp;file=myvideo.mp4" /> 		
		<img src="myvideo.jpg" width="320" height="240" title="No video playback capabilities" />
	</object>
</video>
```

### 3. Startup

#### Automatic start
You can avoid running any startup scripts by added `class="mejs-player"` to the `<video>` or `<audio>` tag. Options can be added using the `data-mejsoptions` attribute
```html	
<video src="myvideo.mp4" width="320" height="240" 
		class="mejs-player" 
		data-mejsoptions='{"alwaysShowControls": true}'></video>
```

#### Normal JavaScirpt
```html
<script>
var player = new MediaElementPlayer('#player', {success: function(mediaElement, originalNode) {
	// do things
}});
</script>	
```

#### jQuery plugin
```html
<script>
$('video').mediaelementplayer({success: function(mediaElement, originalNode) {
	// do things
}});
</script>
```

## How it Works: 
_MediaElement.js: HTML5 `<video>` and `<audio>` shim_

`MediaElement.js` is a set of custom Flash and Silverlight plugins that mimic the HTML5 MediaElement API for browsers that don't support HTML5 or don't support the media codecs you're using. 
Instead of using Flash as a _fallback_, Flash is used to make the browser seem HTML5 compliant and enable codecs like H.264 (via Flash) and even WMV (via Silverlight) on all browsers.
```html
<script src="mediaelement.js"></script>
<video src="myvideo.mp4" width="320" height="240"></video>

<script>
var v = document.getElementsByTagName("video")[0];
new MediaElement(v, {success: function(media) {
	media.play();
}});
</script>
```
You can use this as a standalone library if you wish, or just stick with the full MediaElementPlayer.
