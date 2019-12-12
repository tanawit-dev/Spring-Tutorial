$(document).ready(() => {
   $("#locales").change(() => {
      const selectedOption = $("#locales").val();
      if (selectedOption) {
          window.location.replace(`locale?lang=${selectedOption}`);
      }
   });
});