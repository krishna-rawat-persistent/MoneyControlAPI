package com.psl.MoneyControlAPI.Email;

import com.psl.MoneyControlAPI.model.StockFilter;
import com.psl.MoneyControlAPI.service.StockFilterService;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;


@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	StockFilterService stockFilterService;
	
	public void sendEmail(){
		final String url = "large-cap-fund,mid-cap-fund,multi-cap-fund";
		final String[] durations = new String[]{"oneYear","oneMonth"};
		String body = this.mailBody(url,durations);
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");
			message.setFrom("kkrdaes9341@gmail.com");
			message.setTo(sendEmailIds());
			message.setSubject("Top 5 Stocks of large, mid and ");
			message.setText(body, true);


			mailSender.send(mimeMessage);
		}catch (MessagingException e){
			e.printStackTrace();
		}
	}


	public String mailBody(String url, String[] duration){
		List<StockFilter> stocks = stockFilterService.getStocks(url,duration);
		String table = "<table><thead><tr><th>Scheme Name</th><th>Fund Type</th><th></th>AUM Value</th><th>1W</th><th>1M</th><th>3M</th><th>6M</th><th>1Y</th><th>2Y</th><th>3Y</th><th>5Y</th><th>10Y</th></tr></thead></tbody>";
		for(StockFilter stock:stocks){
			table+="<tr>";
			table+="<td>"+stock.getSchemeName()+"</td>";
			table+="<td>"+stock.getFundName()+"</td>";
			table+="<td>"+stock.getMarketValue()+"</td>";
			table+="<td>"+stock.getOneWeek()+"</td>";
			table+="<td>"+stock.getOneMonth()+"</td>";
			table+="<td>"+stock.getThreeMonth()+"</td>";
			table+="<td>"+stock.getSixMonth()+"</td>";
			table+="<td>"+stock.getOneYear()+"</td>";
			table+="<td>"+stock.getTwoYear()+"</td>";
			table+="<td>"+stock.getThreeYear()+"</td>";
			table+="<td>"+stock.getFiveYear()+"</td>";
			table+="<td>"+stock.getTenYear()+"</td>";
			table+="</tr>";
		}
		table+="</tbody></table>";
		return table;
	}

	
	public String[] sendEmailIds() {
		String[] emailIds = new String[2];
		emailIds[0] = "nancygupta426@gmail.com";
		emailIds[1] = "rawatkrishnakant8319@gmail.com";
		return emailIds;
		}
	
	
}
