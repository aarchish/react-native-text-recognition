Usage Instructions for Users:
In your library's README.md, include these instructions:

markdown
## iOS Installation

1. Add to your Podfile:
```ruby
pod 'TextRecognition', :path => '../node_modules/@jd/react-native-text-recognition/ios'
Make sure these are in your Podfile (they'll be automatically included if not present):

ruby
pod 'GoogleMLKit/TextRecognition', '~> 8.0.0'
pod 'SDWebImage', '~> 5.11.1'
Run:

bash
cd ios && pod install
Note: If you encounter build errors, try adding this to your Podfile's post_install:

ruby
post_install do |installer|
  installer.pods_project.build_configurations.each do |config|
    config.build_settings["EXCLUDED_ARCHS[sdk=iphonesimulator*]"] = "arm64"
  end
end

This setup ensures your library will work seamlessly with the configuration from your Podfile while preventing common installation errors for users.
