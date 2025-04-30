Pod::Spec.new do |s|
    s.name         = "TextRecognition"
    s.version      = "1.0.0"
    s.summary      = "React Native Text Recognition using ML Kit"
    s.description  = <<-DESC
                    A React Native library for text recognition using Google's ML Kit with support for both iOS and Android.
                    Provides accurate text detection from images with bounding box information.
                     DESC
    s.homepage     = "https://github.com/jd/react-native-text-recognition"
    s.license      = { :type => "MIT", :file => "LICENSE" }
    s.author       = { "JD" => "support@jd.com" }
    s.platforms    = { :ios => "16.1" }
    s.source       = { :git => "https://github.com/junaidyounas/react-native-text-recognition.git", :tag => "#{s.version}" }
  
    s.source_files = "ios/*.{h,m}"
    s.requires_arc = true
  
    # Core dependencies
    s.dependency "React-Core"
    s.dependency "GoogleMLKit/TextRecognition", "~> 8.0.0"
    s.dependency "SDWebImage", "~> 5.11.1"
  
    # Make these dependencies optional to prevent conflicts with user's project
    s.weak_framework = 'CoreMedia'
    s.weak_framework = 'CoreVideo'
    s.weak_framework = 'CoreImage'
  
    # Set EXCLUDED_ARCHS for simulator builds
    s.pod_target_xcconfig = {
      "EXCLUDED_ARCHS[sdk=iphonesimulator*]" => "arm64",
      "DEFINES_MODULE" => "YES",
      "OTHER_CFLAGS" => "-DFOLLY_NO_CONFIG -DFOLLY_MOBILE=1 -DFOLLY_USE_LIBCPP=1"
    }
  
    # User might have different React Native version
    s.user_target_xcconfig = {
      "HEADER_SEARCH_PATHS" => "\"$(PODS_ROOT)/Headers/Public/React-Core\"",
      "EXCLUDED_ARCHS[sdk=iphonesimulator*]" => "arm64"
    }
  end