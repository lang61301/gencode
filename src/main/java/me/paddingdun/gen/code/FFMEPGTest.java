package me.paddingdun.gen.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

import com.google.gson.Gson;

import me.paddingdun.gen.code.util.GsonHelper;
import me.paddingdun.gen.code.util.IOHelper;

public class FFMEPGTest {
	
	public static void main(String[] args) {
		MediaInfo m = parse("D:\\home\\program\\ffmpeg-20170425-b4330a0-win64-static\\bin\\cc.mp4");
		if(m != null){
			Gson gson = GsonHelper.create();
			System.out.println(gson.toJson(m));
		}else{
			System.out.println("空空");
		}
	}

	public static MediaInfo parse(String filepath) {
		MediaInfo mediaInfo = null;
		try {
			String info = getFileInfo(filepath);
			mediaInfo = parseFileInfo(info);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mediaInfo;
	}

	public static String getFileInfo(String filepath) {
		StringBuilder sb = new StringBuilder();
		BufferedReader buf = null;
		try {
			List<String> commands = new java.util.ArrayList<String>();
			commands.add("ffmpeg");
			commands.add("-i");
			commands.add(filepath);

			ProcessBuilder builder = new ProcessBuilder();
			builder.command(commands);
			builder.redirectErrorStream(true);
			Process process = builder.start();

			buf = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line = null;
			while ((line = buf.readLine()) != null) {
				sb.append(line);
			}
			process.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOHelper.close(buf);
		}
		return sb.toString();
	}

	public static MediaInfo parseFileInfo(String info) {
		MediaInfo mediaInfo = new MediaInfo();
		try {
			PatternCompiler compiler = new Perl5Compiler();
			String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";
			String regexVideo = "Video: (.*?), (.*?), (\\w*x.*?)[,\\s].*?, (.*?) fps, (.*?) tbr, (.*?) tbn, (\\w*) tbc";
			String regexAudio = "Audio: (\\w*), (\\d*) Hz, (\\w*), (\\w*), (\\d*) kb\\/s";
			Pattern patternDuration = compiler.compile(regexDuration, Perl5Compiler.CASE_INSENSITIVE_MASK);
			PatternMatcher matcherDuration = new Perl5Matcher();
			if (matcherDuration.contains(info, patternDuration)) {
				MatchResult re = matcherDuration.getMatch();
				String durationStr = re.group(1);
				String[] durationArr = durationStr.split(":");
				int duration = 0;
				for (int i = 0; i < durationArr.length; i++) {
					duration += Double.valueOf(durationArr[i]) * Math.pow(60, durationArr.length - 1 - i);
				}
				if (duration >= 2) {
					duration -= 2;
				}
				mediaInfo.setDuration((long) duration);
				mediaInfo.setStart(re.group(2));
				mediaInfo.setBitRate(Integer.valueOf(re.group(3)));
			}

			Pattern patternVideo = compiler.compile(regexVideo, Perl5Compiler.CASE_INSENSITIVE_MASK);
			PatternMatcher matcherVideo = new Perl5Matcher();
			if (matcherVideo.contains(info, patternVideo)) {
				MatchResult re = matcherVideo.getMatch();
				mediaInfo.setVideoCodeType(re.group(1));
				mediaInfo.setVideoType(re.group(2));
				mediaInfo.setVideoPixel(re.group(3));
				mediaInfo.setVideoFps(re.group(4));
				mediaInfo.setVideoTbr(re.group(5));
				mediaInfo.setVideoTbn(re.group(6));
				mediaInfo.setVideoTbc(re.group(7));
			}

			Pattern patternAudio = compiler.compile(regexAudio, Perl5Compiler.CASE_INSENSITIVE_MASK);
			PatternMatcher matcherAudio = new Perl5Matcher();

			if (matcherAudio.contains(info, patternAudio)) {
				MatchResult re = matcherAudio.getMatch();
				mediaInfo.setAudioCodeType(re.group(1));
				mediaInfo.setAudiofreq(re.group(2));
				mediaInfo.setAudioVoice(re.group(3));
				mediaInfo.setAudioInterface(re.group(4));
				mediaInfo.setAudioBitRate(re.group(5));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mediaInfo;
	}

	static class MediaInfo {
		private String videoCodeType;
		private String videoType;
		private String videoPixel;
		private String videoFps;
		private String videoTbr;
		private String videoTbn;
		private String videoTbc;

		private Long duration;
		private String start;
		private Integer bitRate;

		private String audioCodeType;
		private String audiofreq;
		private String audioVoice;
		private String audioInterface;
		private String audioBitRate;

		public String getVideoCodeType() {
			return videoCodeType;
		}

		public void setVideoCodeType(String videoCodeType) {
			this.videoCodeType = videoCodeType;
		}

		public String getVideoType() {
			return videoType;
		}

		public void setVideoType(String videoType) {
			this.videoType = videoType;
		}

		public String getVideoPixel() {
			return videoPixel;
		}

		public void setVideoPixel(String videoPixel) {
			this.videoPixel = videoPixel;
		}

		public String getVideoFps() {
			return videoFps;
		}

		public void setVideoFps(String videoFps) {
			this.videoFps = videoFps;
		}

		public String getVideoTbr() {
			return videoTbr;
		}

		public void setVideoTbr(String videoTbr) {
			this.videoTbr = videoTbr;
		}

		public String getVideoTbn() {
			return videoTbn;
		}

		public void setVideoTbn(String videoTbn) {
			this.videoTbn = videoTbn;
		}

		public String getVideoTbc() {
			return videoTbc;
		}

		public void setVideoTbc(String videoTbc) {
			this.videoTbc = videoTbc;
		}

		public Long getDuration() {
			return duration;
		}

		public void setDuration(Long duration) {
			this.duration = duration;
		}

		public String getStart() {
			return start;
		}

		public void setStart(String start) {
			this.start = start;
		}

		public Integer getBitRate() {
			return bitRate;
		}

		public void setBitRate(Integer bitRate) {
			this.bitRate = bitRate;
		}

		public String getAudioCodeType() {
			return audioCodeType;
		}

		public void setAudioCodeType(String audioCodeType) {
			this.audioCodeType = audioCodeType;
		}

		public String getAudiofreq() {
			return audiofreq;
		}

		public void setAudiofreq(String audiofreq) {
			this.audiofreq = audiofreq;
		}

		public String getAudioVoice() {
			return audioVoice;
		}

		public void setAudioVoice(String audioVoice) {
			this.audioVoice = audioVoice;
		}

		public String getAudioInterface() {
			return audioInterface;
		}

		public void setAudioInterface(String audioInterface) {
			this.audioInterface = audioInterface;
		}

		public String getAudioBitRate() {
			return audioBitRate;
		}

		public void setAudioBitRate(String audioBitRate) {
			this.audioBitRate = audioBitRate;
		}
	}
}