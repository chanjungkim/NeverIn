<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
h1, h2, h3, h4, h5, h6
{
  voice-family: paul;
  voice-stress: moderate;
  cue-before: url(../audio/ping.wav);
  voice-volume: medium 6dB;
}
p.heidi
{
  voice-family: female;
  voice-balance: left;
  voice-pitch: high;
  voice-volume: -6dB;
}
p.peter
{
  voice-family: male;
  voice-balance: right;
  voice-rate: fast;
}
span.special
{
  voice-volume: soft;
  pause-after: strong;
}

</style>
<body>
<h1>I am Paul, and I speak headings.</h1>
<p class="heidi">Hello, I am Heidi.</p>
<p class="peter">
  <span class="special">Can you hear me ?</span>
  I am Peter.
</p>
</body>
</html>