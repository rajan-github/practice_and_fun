package composition;

public class MailerBox1 implements Box, Mailer {
	private Box box;

	public MailerBox1(Box box) {
		this.box = box;
	}

	public void pack() {
		box.pack();
	}

	public void seal() {
		box.seal();
	}

	@Override
	public void addPostage() {
		System.out.println("affix postage");
	}

	@Override
	public void ship() {
		System.out.println("put in mailbox");
	}
}
